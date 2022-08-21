package com.ugo.oze.presentation.userdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import co.windly.limbo.utility.reactive.subscribeOnIo
import com.ugo.oze.domain.manager.UserDomainManager
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.presentation.places.adapter.GithubUserItem
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val userDomainManager: UserDomainManager
) : LimboViewModel() {

    fun setUserAsFavorite(id: Long, isFavorite: Boolean) {
        userDomainManager
            .setUserAsFavorite(id, isFavorite)
            .subscribe(
                ::setUserAsFavoriteSuccess,
                ::setUserAsFavoriteFailure,
            ).addTo(disposables)
    }

    private fun setUserAsFavoriteSuccess() {
        Log.e("TAG_UserDetails", "User successfully saved as favorite")
    }

    private fun setUserAsFavoriteFailure(throwable: Throwable) {
        Log.e("TAG_UserDetails", "Failed to save user as favorite due to $throwable")

    }

}