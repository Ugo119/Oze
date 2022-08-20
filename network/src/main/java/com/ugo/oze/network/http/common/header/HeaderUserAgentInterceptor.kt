package com.ugo.oze.network.http.common.header

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderUserAgentInterceptor @Inject constructor(
) : Interceptor {

    //region Header Key

    companion object {

        const val USER_AGENT_HEADER = "User-Agent"

        const val VALUE = "Oze Android"

    }

    //endregion

    //region Interception

    override fun intercept(chain: Chain): Response {

        // Retrieve original request.
        val original = chain.request()

        // Prepare request builder.
        val builder = original.newBuilder()

        // Proceed with user agent.
        val updated = builder
            .removeHeader(USER_AGENT_HEADER)
            .addHeader(USER_AGENT_HEADER, VALUE)
            .build()

        // Proceed with updated request.
        return chain.proceed(updated)
    }

    //endregion
}
