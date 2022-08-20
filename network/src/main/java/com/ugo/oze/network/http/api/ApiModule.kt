package com.ugo.oze.network.http.api

import com.edukoya.app.network.http.common.CommonModule
import com.ugo.oze.network.http.common.interceptor.ErrorInterceptor
import com.ugo.oze.network.http.api.header.HeaderAuthorizationInterceptor
import com.ugo.oze.network.http.common.header.HeaderUserAgentInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module(includes = [CommonModule::class])
class ApiModule {

    //region Retrofit

    @Provides
    @Singleton
    internal fun provideRetrofit(
        builder: Retrofit.Builder,
        uri: String
    ): Retrofit = builder.baseUrl(uri).build()

    @Provides
    @Singleton
    internal fun provideUri(): String =
        BASE_URL

    @Provides
    @Singleton
    internal fun provideRetrofitBuilder(
        client: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
        converterFactory: Converter.Factory
    ): Retrofit.Builder =
        Retrofit.Builder()
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .client(client)

    //endregion

    //region Http

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        builder: Builder,
        agent: HeaderUserAgentInterceptor,
        logging: HttpLoggingInterceptor,
        authorization: HeaderAuthorizationInterceptor,
        error: ErrorInterceptor
    ): OkHttpClient =
        builder
            .addInterceptor(agent)
            .addInterceptor(error)
            .addInterceptor(logging)
            .addInterceptor(authorization)
            .build()

    @Provides
    @Singleton
    internal fun provideOkHttpClientBuilder(): Builder =
        Builder()
            .connectTimeout(SERVER_CONNECTION_TIMEOUT, SECONDS)
            .readTimeout(SERVER_READ_TIMEOUT, SECONDS)
            .writeTimeout(SERVER_WRITE_TIMEOUT, SECONDS)

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(level: Level): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .also { it.level = level }

    @Provides
    @Singleton
    internal fun provideLogLevel(): Level =
        Level.BODY

    //endregion

    companion object {
        val BASE_URL = "https://api.github.com/"
        val SERVER_CONNECTION_TIMEOUT = 30L
        val SERVER_READ_TIMEOUT = 30L
        val SERVER_WRITE_TIMEOUT = 30L
    }
}
