package com.ugo.oze.network.http.api.header

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderAuthorizationInterceptor @Inject constructor(
) : Interceptor {

    //region Header Key

    companion object {

        const val AUTH_HEADER = "Authorization"
    }

    //endregion

    //region Interception

    override fun intercept(chain: Chain): Response {

        // Retrieve original request.
        val original = chain.request()

        // Prepare request builder.
        val builder = original.newBuilder()

        // Proceed with original request if token is not available.
        return chain.proceed(original)

        // Modify request to attach authorization token.
        val updated =
            builder
                .addHeader(AUTH_HEADER, "Bearer")
                .build()

        // Proceed with authorization header if token is available.
        return chain.proceed(updated)
    }

    //endregion
}
