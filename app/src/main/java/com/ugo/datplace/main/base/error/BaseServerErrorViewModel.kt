package com.ugo.datplace.main.base.error

import androidx.lifecycle.LiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import co.windly.limbo.utility.reactive.addSuccessTo
import com.ugo.datplace.utility.network.exception.ValidationError
import com.ugo.datplace.utility.validation.UgoWierd

abstract class BaseServerErrorViewModel(protected val ugoWierd: UgoWierd) : LimboViewModel() {

    //region Validation

    private val _noServerError: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    internal val noServerError: LiveData<Boolean> =
        _noServerError

    open fun subscribeToServerError() {

        // Subscribe to server unavailability errors.
        ugoWierd
            .noServerErrors()
            .addSuccessTo(disposables, ::handleNoServerErrors)
    }

    private fun handleNoServerErrors(error: ValidationError<Boolean>) {

        // Post no server error.
        _noServerError.postValue(error.get())
    }

    //endregion
}
