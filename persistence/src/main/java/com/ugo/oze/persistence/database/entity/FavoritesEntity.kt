package com.ugo.oze.persistence.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ugo.oze.utility.vocabulary.NONE
import com.ugo.oze.utility.vocabulary.ZERO

@Entity(tableName = "favorites")
data class FavoritesEntity(
    @ColumnInfo(name = "login")
    var login: String = String.NONE,
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Long = Long.ZERO,
    @ColumnInfo(name = "node_id")
    var node_id: String = String.NONE,
    @ColumnInfo(name = "avatar_url")
    var avatar_url: String = String.NONE,
    @ColumnInfo(name = "gravatar_id")
    var gravatar_id: String = String.NONE,
    @ColumnInfo(name = "url")
    var url: String = String.NONE,
    @ColumnInfo(name = "html_url")
    var html_url: String = String.NONE,
    @ColumnInfo(name = "followers_url")
    var followers_url: String = String.NONE,
    @ColumnInfo(name = "following_url")
    var following_url: String = String.NONE,
    @ColumnInfo(name = "gists_url")
    var gists_url: String = String.NONE,
    @ColumnInfo(name = "starred_url")
    var starred_url: String = String.NONE,
    @ColumnInfo(name = "subscriptions_url")
    var subscriptions_url: String = String.NONE,
    @ColumnInfo(name = "organizations_url")
    var organizations_url: String = String.NONE,
    @ColumnInfo(name = "repos_url")
    var repos_url: String = String.NONE,
    @ColumnInfo(name = "events_url")
    var events_url: String = String.NONE,
    @ColumnInfo(name = "received_events_url")
    var received_events_url: String = String.NONE,
    @ColumnInfo(name = "type")
    var type: String = String.NONE,
    @ColumnInfo(name = "site_admin")
    var site_admin: Boolean = false,
    @ColumnInfo(name = "score")
    var score: Long = Long.ZERO,

)