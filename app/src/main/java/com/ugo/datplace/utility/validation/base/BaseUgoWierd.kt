package com.ugo.datplace.utility.validation.base

import androidx.lifecycle.MutableLiveData

abstract class BaseUgoWierd {

    //region Various

    protected fun invalid(
        stream: MutableLiveData<String?>?,
        message: String
    ): Boolean {
        stream
            ?.postValue(message)
            .also { return false }
    }

    protected fun valid(stream: MutableLiveData<String?>?): Boolean {
        stream
            ?.postValue(null)
            .also { return true }
    }

    //endregion
}