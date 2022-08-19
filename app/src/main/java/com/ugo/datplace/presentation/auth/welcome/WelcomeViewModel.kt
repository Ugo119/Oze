package com.ugo.datplace.presentation.auth.welcome

import androidx.lifecycle.LiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
) : LimboViewModel() {

    init {
    }

    //region Create Account

    private val _createAccountClicked: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val createAccountClicked: LiveData<Boolean> =
        _createAccountClicked

    fun onCreateAccountClicked() {
        _createAccountClicked.postValue(true)
    }

    //endregion

    // region Login

    private val _loginClicked: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val loginClicked: LiveData<Boolean> =
        _loginClicked

    fun onLoginClicked() {
        _loginClicked.postValue(true)
    }

    // endregion


}
