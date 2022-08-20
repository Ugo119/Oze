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

//    fun insert(user: UserEntity): Completable =
//        userDao
//            .insert(user)
//            .subscribeOnIo()
//            .ignoreElement()

    fun observeUsersByType(type: String): Flowable<List<UserEntity>> =
        userDao
            .observeUsersByType(type)
            .subscribeOnIo()

//    fun getPastPapersById(pastPaperId: Long): Single<UserEntity> =
//        userDao
//            .getPastPapersById(pastPaperId)
//            .subscribeOnIo()
//
//    fun checkPastPaperDownloaded(pastPaperId: Long): Single<Boolean> =
//        userDao
//            .checkPastPaperDownloaded(pastPaperId)
//            .subscribeOnIo()
//
//    fun setPastPaperDownloaded(pastPaperId: Long, downloaded: Boolean): Completable =
//        userDao
//            .setPastPaperDownloaded(pastPaperId, downloaded)
//            .subscribeOnIo()
//
//    fun removeAllCachedUsers(): Completable =
//        userDao
//            .removeAllCachedPastPapers()
//            .subscribeOnIo()
}