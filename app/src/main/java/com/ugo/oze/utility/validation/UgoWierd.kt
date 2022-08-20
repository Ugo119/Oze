package com.ugo.oze.utility.validation

import androidx.lifecycle.MutableLiveData
import com.ugo.oze.utility.network.NetworkUgoWierd
import com.ugo.oze.utility.network.exception.ValidationFieldError
import com.ugo.oze.utility.validation.local.LocalUgoWierd
import javax.inject.Inject

class UgoWierd @Inject constructor(
    private val local: LocalUgoWierd,
    private val network: NetworkUgoWierd
) : Validator() {

    //region Api

    fun validateApiError(
        error: ValidationFieldError,
        stream: MutableLiveData<String?>?
    ): Boolean =
        network.validateApiError(error, stream)

    //endregion

    //region Emptiness

    fun validateEmptiness(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean =
        local.validateEmptiness(input, stream)

    //endregion

    //region Min Length

    fun validateMinLength(
        input: String?,
        stream: MutableLiveData<String?>?,
        min: Int
    ): Boolean =
        local.validateMinLength(input, stream, min)

    //endregion

    //region Number Not Start with Zero

    fun validateNumberFormat(
        input: String?,
        stream: MutableLiveData<String?>?,
    ): Boolean =
        local.validateNumberFormat(input, stream)

    //endregion

    fun countryCodeCheck(
        input: String?,
        countryCode: String,
        stream: MutableLiveData<String?>?,
    ): Boolean =
        local.countryCodeCheck(input, countryCode, stream)

    //region Username

    fun validateUsernameAvailable(
        input: String?,
        stream: MutableLiveData<String?>?,
        available: Boolean
    ): Boolean =
        local.validateUsernameAvailable(input, stream, available)

    //endregion

    //region Email

    fun validateEmail(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean =
        local.validateEmail(input, stream)

    fun validateEmailAvailable(
        input: String?,
        stream: MutableLiveData<String?>?,
        available: Boolean
    ): Boolean =
        local.validateEmailAvailable(input, stream, available)

    //endregion

    //region Password

    fun validatePasswordCase(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean =
        local.validatePasswordCase(input, stream)

    //endregion
}

@Suppress("NOTHING_TO_INLINE")
inline fun List<() -> Boolean>.validateFailFast(): Boolean =
    this.all { it.invoke() }

@Suppress("NOTHING_TO_INLINE", "SimplifiableCallChain")
inline fun List<() -> Boolean>.validateAgainstAll(): Boolean =
    this.filter { !it.invoke() }.isEmpty()
