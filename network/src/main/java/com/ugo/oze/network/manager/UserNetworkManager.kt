package com.ugo.oze.network.manager

import com.ugo.oze.network.dto.UserDto
import com.ugo.oze.network.dto.base.PageDto
import com.ugo.oze.network.service.UserApi
import io.reactivex.Single
import javax.inject.Inject

class UserNetworkManager @Inject constructor(
    private val api: UserApi
) {
    fun getGithubUsers(location: String, page: Long, itemsPerPage: Long): Single<PageDto<UserDto>> =
        api.getGithubUsers(location, page, itemsPerPage)
}