package com.ugo.oze.network.http.common.interceptor

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import co.windly.limbo.utility.network.NetworkException
import co.windly.limbo.utility.network.UnknownException
import co.windly.limbo.utility.network.definition.HttpCode
import com.edukoya.app.network.dto.error.ResourceNotFoundErrorDto
import com.ugo.oze.network.dto.error.ValidationErrorDto
import com.edukoya.app.network.dto.error.VersionCodeErrorDto
import com.edukoya.app.utility.network.exception.*
import com.google.gson.Gson
import com.ugo.oze.network.dto.error.BusinessErrorDto
import com.ugo.oze.utility.network.exception.ValidationFieldError
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ErrorInterceptor @Inject constructor(
    private val gson: Gson,
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Chain): Response {

        // Retrieve original response.
        val response = chain.proceed(chain.request())

        // Return unmodified response for successful response.
        if (response.isSuccessful) {
            return response
        }

        // Map error response exception.
        throw exceptionFrom(response)
    }

    private fun exceptionFrom(response: Response): NetworkException = when (response.code) {

        // Handle bad request error code.
        HttpCode.BAD_REQUEST -> BadRequestException(response.message)

        // Handle unauthorized error code.
        HttpCode.UNAUTHORIZED -> UnauthorizedException()

        // Handle conflict error code.
        HttpCode.CONFLICT -> apiExceptionFrom(response.body)

        // Handle validation error codes.
        ValidationError.VALIDATION_ERROR -> validationFieldExceptionFrom(response.body)

        // Handle internal server error code.
        HttpCode.INTERNAL_SERVER_ERROR -> ServerErrorException(response.message)

        // Handle update app version error code.
        ValidationError.VERSION_CODE_ERROR -> {
            sendUpdateVersionBroadcast()
            versionCodeExceptionFrom(response.body)
        }

        // Handle solution unavailable error
        ValidationError.RESOURCE_NOT_FOUND -> resourceNotFoundException(response.body)

        // Raise unknown exception.
        else -> UnknownException()
    }

    private fun sendUpdateVersionBroadcast() {
        val updateAppVersionAction = "${context.packageName}.UPDATE_APP_VERSION_CODE"
        LocalBroadcastManager
            .getInstance(context)
            .sendBroadcast(Intent(updateAppVersionAction))
    }

    private fun apiExceptionFrom(body: ResponseBody?): NetworkException {

        // Return unknown error for missing body.
        body ?: return UnknownException()

        // Parse json body.
        val parsed = gson.fromJson(body.string(), BusinessErrorDto::class.java)

        // Return API exception.
        return ApiException(parsed.code, parsed.resultKey)
    }

    private object ValidationError {

        /**
         * Validation error code.
         */
        const val VALIDATION_ERROR = 422

        const val VERSION_CODE_ERROR = 412

        const val RESOURCE_NOT_FOUND = 404
    }


    private fun validationFieldExceptionFrom(body: ResponseBody?): NetworkException {

        // Return unknown error for missing body.
        body ?: return UnknownException()

        // Parse json body.
        val parsed = gson.fromJson(body.string(), ValidationErrorDto::class.java)

        if (parsed.messages.isNotEmpty()) {

            // Retrieve all error messages.
            val errorMessages =
                parsed
                    .messages
                    .map {
                        ValidationFieldError(
                            field = it.key,
                            messages = it.value
                        )
                    }

            // Return API exception.
            return ValidationFieldException(parsed.code, errorMessages)

        } else {

            // Return API exception.
            return ValidationException(parsed.code, parsed.message)
        }
    }

    private fun versionCodeExceptionFrom(body: ResponseBody?): NetworkException {

        // Return unknown error for missing body.
        body ?: return UnknownException()
        // Parse json body.
        val parsed = gson.fromJson(body.string(), VersionCodeErrorDto::class.java)

        return VersionCodeException(parsed.code, parsed.message)

    }

    private fun resourceNotFoundException(body: ResponseBody?): NetworkException {

        // Return unknown error for missing body.
        body ?: return UnknownException()
        // Parse json body.
        val parsed = gson.fromJson(body.string(), ResourceNotFoundErrorDto::class.java)

        return ResourceNotFoundException(parsed.code, parsed.message)

    }


}
