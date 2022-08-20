package com.ugo.oze.network.service

import com.ugo.oze.network.dto.UserDto
import com.ugo.oze.network.dto.base.PageDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("search/users")
    fun getGithubUsers(
        @Query("q") location: String,
        @Query("page") page: Long
    ): Single<PageDto<UserDto>>
}