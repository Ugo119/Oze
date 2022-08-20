package com.ugo.oze.domain.model.user

import android.os.Parcelable
import com.ugo.oze.utility.vocabulary.NONE
import com.ugo.oze.utility.vocabulary.ZERO

import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var login: String = String.NONE,
    var id: Long = Long.ZERO,
    var node_id: String = String.NONE,
    var avatar_url: String = String.NONE,
    var gravatar_id: String = String.NONE,
    var url: String = String.NONE,
    var html_url: String = String.NONE,
    var followers_url: String = String.NONE,
    var following_url: String = String.NONE,
    var gists_url: String = String.NONE,
    var starred_url: String = String.NONE,
    var subscriptions_url: String = String.NONE,
    var organizations_url: String = String.NONE,
    var repos_url: String = String.NONE,
    var events_url: String = String.NONE,
    var received_events_url: String = String.NONE,
    var type: String = String.NONE,
    var site_admin: Boolean = false,
    var score: Long = Long.ZERO,
) : Parcelable
