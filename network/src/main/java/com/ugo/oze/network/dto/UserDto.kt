package com.ugo.oze.network.dto

import com.google.gson.annotations.SerializedName
import com.ugo.oze.utility.vocabulary.NONE
import com.ugo.oze.utility.vocabulary.ZERO

data class UserDto(
    @SerializedName("login")
    var login: String = String.NONE,
    @SerializedName("id")
    var id: Long = Long.ZERO,
    @SerializedName("node_id")
    var node_id: String = String.NONE,
    @SerializedName("avatar_url")
    var avatar_url: String = String.NONE,
    @SerializedName("gravatar_id")
    var gravatar_id: String = String.NONE,
    @SerializedName("url")
    var url: String = String.NONE,
    @SerializedName("html_url")
    var html_url: String = String.NONE,
    @SerializedName("followers_url")
    var followers_url: String = String.NONE,
    @SerializedName("following_url")
    var following_url: String = String.NONE,
    @SerializedName("gists_url")
    var gists_url: String = String.NONE,
    @SerializedName("starred_url")
    var starred_url: String = String.NONE,
    @SerializedName("subscriptions_url")
    var subscriptions_url: String = String.NONE,
    @SerializedName("organizations_url")
    var organizations_url: String = String.NONE,
    @SerializedName("repos_url")
    var repos_url: String = String.NONE,
    @SerializedName("events_url")
    var events_url: String = String.NONE,
    @SerializedName("received_events_url")
    var received_events_url: String = String.NONE,
    @SerializedName("type")
    var type: String = String.NONE,
    @SerializedName("site_admin")
    var site_admin: Boolean = false,
    @SerializedName("score")
    var score: Long = Long.ZERO,
)