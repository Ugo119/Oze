package com.ugo.datplace.main.base.error

import androidx.lifecycle.LiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.utility.reactive.addSuccessTo
import com.ugo.datplace.utility.network.exception.ResourceNotFoundException
import com.ugo.datplace.utility.network.exception.ValidationError
import com.ugo.datplace.utility.network.exception.ValidationException
import com.ugo.datplace.utility.validation.UgoWierd
import com.ugo.datplace.utility.validation.error.ErrorResources
import java.net.UnknownHostException

@Suppress("VariableNaming")
abstract class BaseErrorViewModel(ugoWierd: UgoWierd) : BaseServerErrorViewModel(ugoWierd) {

    //region General

    protected val _snackbarError: SingleLiveEvent<String?> =
        SingleLiveEvent()

    val snackbarError: LiveData<String?> =
        _snackbarError

    fun handleBaseErrors(errorResources: ErrorResources, throwable: Throwable) {

        // Map to message.
        val message = when (throwable) {
            is UnknownHostException -> errorResources.serverUnreachable()
            is ResourceNotFoundException -> throwable.message
            is ValidationException -> throwable.message
            else -> errorResources.unknownError()
        }

        // Send message.
        _snackbarError.postValue(message)
    }

    //endregion

    //region Validation

    private val _badRequestError: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val badRequestError: LiveData<Boolean> =
        _badRequestError

    protected val _noNetworkError: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val noNetworkError: LiveData<Boolean> =
        _noNetworkError

    private val _nonFieldError: SingleLiveEvent<String> =
        SingleLiveEvent()

    internal val nonFieldError: LiveData<String> =
        _nonFieldError

    private val _unauthorizedError: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val unauthorizedError: LiveData<Boolean> =
        _unauthorizedError

    open fun subscribeToErrors() {

        // Subscribe to server unavailability errors.
        subscribeToServerError()

        // Subscribe to bad request errors.
        ugoWierd
            .badRequestErrors()
            .addSuccessTo(disposables, ::handleBadRequestErrors)

        // Subscribe to non-field validation errors.
        ugoWierd
            .nonFieldErrors()
            .addSuccessTo(disposables, ::handleNonFieldErrors)

        // Subscribe to unauthorized errors.
        ugoWierd
            .unauthorizedErrors()
            .addSuccessTo(disposables, ::handleUnauthorizedErrors)
    }

    private fun handleBadRequestErrors(error: ValidationError<Boolean>) {

        // Post no server error.
        _badRequestError.postValue(error.get())
    }

    private fun handleNonFieldErrors(error: ValidationError<String?>) {

        // Post non field error.
        _nonFieldError.postValue(error.get().toString())
    }

    private fun handleUnauthorizedErrors(error: ValidationError<Boolean>) {

        // Post no server error.
        _unauthorizedError.postValue(error.get())
    }

    //endregion

}
