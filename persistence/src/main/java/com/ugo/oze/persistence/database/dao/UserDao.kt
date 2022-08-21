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

    @Query(value = "UPDATE user SET is_favorite = :is_favorite WHERE id = :userId")
    abstract fun setUserAsFavorite(userId: Long, is_favorite: Boolean): Completable
}