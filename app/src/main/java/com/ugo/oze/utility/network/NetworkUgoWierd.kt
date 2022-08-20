package com.ugo.oze.utility.network

import androidx.lifecycle.MutableLiveData
import com.ugo.oze.utility.network.exception.ValidationFieldError
import com.ugo.oze.utility.validation.base.BaseUgoWierd
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NetworkUgoWierd @Inject constructor() :
    BaseUgoWierd() {

    companion object {
        const val DISPLAY_MESSAGE_NUMBER = 0
    }

    //region Api

    fun validateApiError(error: ValidationFieldError, stream: MutableLiveData<String?>?): Boolean {

        // Emit no error preemptively.
        if (error.messages.isEmpty()) {
            return valid(stream)
        }
        // Emit error.
        return invalid(stream, error.messages[DISPLAY_MESSAGE_NUMBER])
    }

    //endregion
}