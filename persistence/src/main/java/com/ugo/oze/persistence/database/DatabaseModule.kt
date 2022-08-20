package com.ugo.oze.persistence.database

import android.content.Context
import androidx.room.Room
import com.ugo.oze.persistence.database.migration.Migrations.ALL_MIGRATIONS
import com.ugo.oze.persistence.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    //region Dao

    @Provides
    @Singleton
    internal fun provideUserDao(database: AndroidDatabase): UserDao =
        database.userDao()


    //endregion

    //region Database

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): AndroidDatabase =
        Room
            .databaseBuilder(context, AndroidDatabase::class.java, Configuration.NAME)
            .addMigrations(*ALL_MIGRATIONS)
            .fallbackToDestructiveMigration()
            .build()

    //endregion

    //region Configuration

    internal object Configuration {
        internal const val NAME = "Oze.db"
    }

    //endregion
}
