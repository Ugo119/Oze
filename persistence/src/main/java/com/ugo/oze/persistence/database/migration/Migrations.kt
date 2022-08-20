package com.ugo.oze.persistence.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    // region 1 -> 2

    /*private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE past_paper ADD COLUMN downloaded INTEGER DEFAULT 0 NOT NULL"
            )
        }
    }*/

    // endregion


    // region All

    val ALL_MIGRATIONS = arrayOf<Migration>()

    // endregion

}
