package com.ugo.datplace.main.base.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import com.ugo.datplace.main.base.error.BaseErrorViewModel
import com.ugo.datplace.presentation.auth.error.RegisterErrorType
import com.ugo.datplace.utility.network.exception.ValidationFieldException
import com.ugo.datplace.utility.validation.UgoWierd
import com.ugo.datplace.utility.validation.ValidationSettings.DEFAULT_COUNTRY_CODE
import com.ugo.datplace.utility.validation.ValidationSettings.MIN_PASSWORD_LENGTH
import com.ugo.datplace.utility.validation.ValidationSettings.MIN_PHONE_LENGTH
import com.ugo.datplace.utility.validation.error.ErrorResources
import com.ugo.datplace.utility.validation.local.LocalResources
import java.net.UnknownHostException

@Suppress("TooManyFunctions", "LongParameterList")
abstract class BaseLoginViewModel(
    ugoWierd: UgoWierd,
    val errorResources: ErrorResources,
    var localResources: LocalResources,
) : BaseErrorViewModel(ugoWierd) {

    private val _loginSuccess: SingleLiveEvent<Boolean> = SingleLiveEvent()

    val loginSuccess: SingleLiveEvent<Boolean> = _loginSuccess

    private val _passwordError: SingleLiveEvent<String?> = SingleLiveEvent()

    val passwordError: SingleLiveEvent<String?> = _passwordError

    private val _phoneNumberError: SingleLiveEvent<String?> = SingleLiveEvent()

    val phoneNumberError: SingleLiveEvent<String?> = _phoneNumberError

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    val loading: LiveData<Boolean> = _loading

    var userPhoneNumber = ""

    @Suppress("UNUSED_PARAMETER")
    fun onPasswordChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _passwordError.setValue(null)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onPhoneNumberChangedChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _phoneNumberError.setValue(null)
    }

    private fun login(
        phoneNumber: String,
        password: String
    ) { }

    private fun handleLoginSuccess() {
        _loginSuccess.postValue(true)
    }

    private fun handleLoginError(throwable: Throwable) {
        // Check validation field exception.
        when (throwable) {
            is ValidationFieldException -> {

                // Iterate over all field errors.
                throwable.fieldErrors.forEach {
                    when (it.field) {
                        // Validate phonenumber.
                        RegisterErrorType.PHONE_NUMBER ->
                            ugoWierd.validateApiError(it, phoneNumberError)

                        // Validate password.
                        RegisterErrorType.PASSWORD ->
                            ugoWierd.validateApiError(it, passwordError)
                    }
                }
            }
            is UnknownHostException -> {
                handleBaseErrors(errorResources, throwable)
            }
            else -> {
                _loginSuccess.postValue(false)
            }
        }
    }

    fun onLoginClicked(phoneNumber: String?, password: String?) {
        var validNumber: String? = ""
        if (isValidPhoneNumber(phoneNumber) && isValidPassword(password)) {
            if (phoneNumber?.startsWith("0") == true) {
                validNumber = phoneNumber.drop(1)
            } else {
                validNumber = phoneNumber
            }
            val completePhoneNumber =
                currentCountryCode + validNumber.orEmpty().trim()
            userPhoneNumber = completePhoneNumber

            _loginSuccess.postValue(true)

//            login(completePhoneNumber, password.orEmpty())
        }
    }

    private fun isValidPassword(password: String?): Boolean {
        return ugoWierd.validateEmptiness(
            password, _passwordError
        ) && ugoWierd.validateMinLength(
            password,
            _passwordError,
            MIN_PASSWORD_LENGTH
        ) && ugoWierd.validatePasswordCase(
            password,
            _passwordError
        )
    }

    private fun isValidPhoneNumber(phoneNumber: String?): Boolean {
        return ugoWierd.validateEmptiness(
            phoneNumber,
            _phoneNumberError
        ) && ugoWierd.validateMinLength(
            phoneNumber,
            _phoneNumberError,
            MIN_PHONE_LENGTH
        ) && ugoWierd.validateNumberFormat(
            phoneNumber,
            _phoneNumberError
        )
    }

    private fun updateVerifyProgress(inProgress: Boolean) {
        _loading.postValue(inProgress)
    }

    //region Country Picker

    var currentCountryCode = DEFAULT_COUNTRY_CODE

    fun onCountryCodeChanged(countryCode: String) {
        currentCountryCode = countryCode
    }

    //endregion

}