package com.ugo.oze.domain.manager

import com.ugo.oze.domain.mapper.UserMapper
import com.ugo.oze.domain.model.base.Meta
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.network.manager.UserNetworkManager
import com.ugo.oze.persistence.manager.UserPersistenceManager
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class UserDomainManager @Inject constructor(
    private val mapper: UserMapper,
    private val network: UserNetworkManager,
    private val persistence: UserPersistenceManager
) {

    // region Download and Save Github Users

    fun downloadGithubUsers(
        location: String,
        page: Long,
        itemsPerPage: Long,
    ): Single<Meta<User>> =
        network
            .getGithubUsers(location, page, itemsPerPage)
            .flatMap {

                // Map entities.
                val entities =
                    mapper.mapDtoListToEntityList(it.items)

                val meta =
                    mapper.mapPageDtoToDomain(it)

                // Save and return page metadata.
                persistence
                    .insertIgnoreConflict(entities)
                    .toSingleDefault(meta)
            }

    // endregion

    //region Users - Observe

    fun observeUsers(type: String): Flowable<List<User>> =
        persistence
            .observeUsersByType(type)
            .map(mapper::mapEntityListToDomainList)

    //endregion

    // region Set User As Favorite

    fun setUserAsFavorite (userId: Long, is_favorite: Boolean): Completable =
        persistence
            .setUserAsFavorite(userId, is_favorite)

    // endregion
}