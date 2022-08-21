package com.ugo.oze.persistence.manager

import co.windly.limbo.utility.reactive.subscribeOnIo
import com.ugo.oze.persistence.database.dao.UserDao
import com.ugo.oze.persistence.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.annotations.SchedulerSupport
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@SchedulerSupport(value = SchedulerSupport.IO)
class UserPersistenceManager  @Inject constructor(
    private val userDao: UserDao
) {

    fun removeAllUsers(): Completable =
        userDao.clearTable()
            .subscribeOnIo()

    fun insert(users: List<UserEntity>): Completable =
        userDao
            .insert(users)
            .subscribeOnIo()

    fun insertIgnoreConflict(users: List<UserEntity>): Completable =
        userDao
            .insertIgnoreConflict(users)
            .subscribeOnIo()

    fun observeUsersByType(type: String): Flowable<List<UserEntity>> =
        userDao
            .observeUsersByType(type)
            .subscribeOnIo()

    fun setUserAsFavorite(userId: Long, is_favorite: Boolean): Completable =
        userDao
            .setUserAsFavorite(userId, is_favorite)
            .subscribeOnIo()
}