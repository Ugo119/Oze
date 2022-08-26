package com.ugo.oze.presentation.places

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import com.ugo.oze.domain.manager.UserDomainManager
import com.ugo.oze.domain.model.base.Meta
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.presentation.places.adapter.GithubUserItem
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
    private val userDomainManager: UserDomainManager
) : LimboViewModel() {

    //region Paging

    private var meta: Meta<User> = Meta()

    var currentPage = 1L

    fun loadNextPage() {

        currentPage += 1

        val isNextAvailable: Boolean =
        meta.items.size <= meta.total_count

        // Do nothing if all data downloaded.
        if (!isNextAvailable) {
            return
        }

        // Calculate next page.
        val next: Long = currentPage

        Log.e("TAG_Profiles", "Next = $next")

        // Download next page of data.
        fetchGithubUsers(page = next)
    }

    //endregion

    // region DownloadUsers Meta

    fun fetchGithubUsers(page: Long = FIRST_PAGE) {
        userDomainManager
            .downloadGithubUsers(LOCATION, page, ITEMS_PER_PAGE)
            .doOnSubscribe { updateProgress(true) }
            .doFinally { updateProgress(false) }
            .subscribe(
                this::handleDownloadUsersSuccess,
                this::handleDownloadUsersError
            ).addTo(disposables)
    }

    private fun handleDownloadUsersSuccess(meta: Meta<User>) {
        observeUsers()
        // Save meta for later use.
        this.meta = meta
    }

    private fun handleDownloadUsersError(throwable: Throwable) {

        // Show error message
        Log.e("TAG_Download_Meta", "$throwable")

    }

    // endregion

    //region Observe Users

    private val _users: MutableLiveData<List<GithubUserItem>> = MutableLiveData(emptyList())

    val users: LiveData<List<GithubUserItem>> = _users

    fun observeUsers() {
        userDomainManager
            .observeUsers(TYPE)
            .subscribe(
                this::handleObserveUsersSuccess,
                this::handleObserveUsersError
            ).addTo(disposables)
    }

    private fun handleObserveUsersSuccess(list: List<User>) {
        Log.e("TAG_Download_Meta", "UPDATED: $list")
        _users.postValue(list.map { GithubUserItem(it) })
    }

    private fun handleObserveUsersError(throwable: Throwable) {
        // Show error message
        Log.e("TAG_Download_Meta", "$throwable")
        Log.e("TAG_Download_Meta","An error occurred while fetching users from db.")
    }

    //endregion

    // region User Item Clicked

    private val _userClickAction: SingleLiveEvent<User> = SingleLiveEvent()
    internal val userClickAction: LiveData<User> = _userClickAction

    fun onUserItemClicked(user: User) {
        _userClickAction.postValue(user)
    }

    // endregion

    // region Delete All Users

    fun deleteAllUsers() {
        userDomainManager
            .deleteAllUsers()
            .subscribe(
                ::onDeleteAllUsersSuccess,
                ::onDeleteAllUsersError
            ).addTo(disposables)
    }

    fun onDeleteAllUsersSuccess() {
        Log.e("TAG_Users", "All users deleted successfully!")
    }

    fun onDeleteAllUsersError(throwable: Throwable) {
        Log.e("TAG_Users","An error occurred while deleting users from db!!")
    }

    // endregion

    companion object {
        const val FIRST_PAGE = 1L
        const val LOCATION = "lagos"
        const val TYPE = "User"
        const val ITEMS_PER_PAGE = 15L
    }

    //region Loading

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private fun updateProgress(inProgress: Boolean) {
        _loading.postValue(inProgress)
    }

    //endregion


}