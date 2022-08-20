package com.ugo.oze.network

import com.edukoya.app.network.http.common.CommonModule
import com.ugo.oze.network.http.api.ApiModule
import com.ugo.oze.network.service.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module(
    includes = [ApiModule::class])
class NetworkModule {

    //region User

    @Provides
    @Singleton
    internal fun provideUserApi(retrofit: Retrofit): UserApi =
        retrofit.create()

    //endregion


}
