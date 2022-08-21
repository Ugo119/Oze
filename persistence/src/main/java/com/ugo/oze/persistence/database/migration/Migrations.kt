package com.ugo.oze.persistence.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    // region 1 -> 2

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                """CREATE TABLE IF NOT EXISTS favorites (
    `login`TEXT NOT NULL,
    `id` INTEGER NOT NULL,
    `node_id` TEXT NOT NULL,
    `avatar_url` TEXT NOT NULL,
    `gravatar_id` TEXT NOT NULL,
    `url` TEXT NOT NULL,
    `html_url` TEXT NOT NULL,
    `followers_url` TEXT NOT NULL,
    `following_url` TEXT NOT NULL,
    `gists_url` TEXT NOT NULL,
    `starred_url` TEXT NOT NULL,
    `subscriptions_url` TEXT NOT NULL,
    `organizations_url` TEXT NOT NULL,
    `repos_url` TEXT NOT NULL,
    `events_url` TEXT NOT NULL,
    `received_events_url` TEXT NOT NULL,
    `type` TEXT NOT NULL,
    `site_admin` INTEGER NOT NULL,
    `score` INTEGER NOT NULL,
    PRIMARY KEY(`id`)
                    )""".trimIndent()

            )
        }
    }

    // endregion

    // region 2 -> 3

    private val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE user ADD COLUMN is_favorite INTEGER")
        }
    }

    // endregion

    // region All

    val ALL_MIGRATIONS = arrayOf(
        MIGRATION_1_2,
        MIGRATION_2_3,
    )

    // endregion

}
