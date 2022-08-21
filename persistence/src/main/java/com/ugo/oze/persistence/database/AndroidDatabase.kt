package com.ugo.oze.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ugo.oze.persistence.database.dao.UserDao
import com.ugo.oze.persistence.database.entity.FavoritesEntity
import com.ugo.oze.persistence.database.entity.UserEntity

@Database(
    version = 3,
    exportSchema = true,
    entities = [
        UserEntity::class,
        FavoritesEntity::class,
    ]
)
abstract class AndroidDatabase : RoomDatabase() {
    //region Dao

    abstract fun userDao(): UserDao

    //endregion
}
