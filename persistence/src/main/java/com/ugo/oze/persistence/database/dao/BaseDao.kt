package com.ugo.oze.persistence.database.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
@Suppress("UnnecessaryAbstractClass")
@Dao
abstract class BaseDao<Entity> {

    //region Insert

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: Entity): Single<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entities: Iterable<Entity>): Completable

    //endregion

    //region Removed

    @Delete
    abstract fun remove(entity: Entity): Single<Int>

    @Delete
    abstract fun remove(entities: Iterable<Entity>): Completable

    //endregion

    //region Update

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entity: Entity): Single<Int>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entities: Iterable<Entity>): Completable

    //endregion
}
