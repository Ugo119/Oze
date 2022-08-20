package com.ugo.oze.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ugo.oze.persistence.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class UserDao : BaseDao<UserEntity>(){

    @Query(value = "DELETE FROM user")
    abstract fun clearTable(): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnoreConflict(entities: Iterable<UserEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnoreConflict(entity: UserEntity): Single<Long>

    @Query(value = " SELECT * FROM user WHERE type = :type")
    abstract fun observeUsersByType(type: String): Flowable<List<UserEntity>>

//    @Query(
//        value = """ SELECT * FROM user WHERE subject_id = :subjectId
//                 and topics != '[]' ORDER BY year LIMIT :limit"""
//    )
//    abstract fun getRandomPastPapersBySubject(
//        subjectId: Long,
//        limit: Int = 2
//    ): Single<List<UserEntity>>
//
//    @Query(value = " SELECT * FROM user WHERE id = :pastPaperId")
//    abstract fun getPastPapersById(pastPaperId: Long): Single<UserEntity>
//
//    @Query(value = " SELECT downloaded FROM user WHERE id = :pastPaperId")
//    abstract fun checkPastPaperDownloaded(pastPaperId: Long): Single<Boolean>
//
//    @Query(value = "UPDATE user SET downloaded = :downloaded WHERE id = :pastPaperId")
//    abstract fun setPastPaperDownloaded(pastPaperId: Long, downloaded: Boolean): Completable
//
//    @Query(value = "UPDATE user SET topics = '[]' WHERE downloaded = 0")
//    abstract fun removeAllCachedPastPapers(): Completable
}