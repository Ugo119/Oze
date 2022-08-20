package com.ugo.oze.presentation.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.windly.limbo.mvvm.lifecycle.SingleLiveEvent
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import com.ugo.oze.utility.validation.UgoWierd
import com.ugo.oze.utility.validation.ValidationSettings.DEFAULT_COUNTRY_CODE
import com.ugo.oze.utility.validation.ValidationSettings.MIN_PHONE_LENGTH
import com.ugo.oze.utility.vocabulary.NONE
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor(
    private val ugoWierd: UgoWierd
) : LimboViewModel() {

    //region Send

    private val _otpSend: SingleLiveEvent<SendResult> =
        SingleLiveEvent()

    internal val otpSend: LiveData<SendResult> =
        _otpSend

    //endregion

    //region Phone Number

    private lateinit var passedPhoneNumber: String

    //endregion

    //region Valid Phone Number [Errors]

    private val _validPhoneNumber: MutableLiveData<String?> =
        MutableLiveData()

    val validPhoneNumber: LiveData<String?> =
        _validPhoneNumber

    //endregion

    //region Loading

    private val _loading: MutableLiveData<Boolean> =
        MutableLiveData()

    val loading: LiveData<Boolean> =
        _loading

    //endregion

    //region Login

    private val _loginClicked: SingleLiveEvent<Any> =
        SingleLiveEvent()

    internal val loginClicked: LiveData<Any> =
        _loginClicked

    fun onLoginClicked() {
        _loginClicked.post()
    }

    //endregion

    //region Send Methods

    fun onSubmitClicked(phoneNumber: String?) {
        var validNumber: String? = ""
        if (phoneNumber?.startsWith("0") == true) {
            validNumber = phoneNumber.drop(1)
        } else {
            validNumber = phoneNumber
        }
        passedPhoneNumber = currentCountryCode + validNumber
        if (ugoWierd.validateEmptiness(validNumber, _validPhoneNumber) &&
            ugoWierd.validateMinLength(validNumber, _validPhoneNumber, MIN_PHONE_LENGTH) &&
            ugoWierd.validateNumberFormat(validNumber, _validPhoneNumber)
        ) {
            _loading.postValue(true)
        }
    }

    private fun handleOTPSendSuccess(success: Boolean) {
        _loading.postValue(false)
        when (success) {
            true -> _otpSend.postValue(
                SendResult(
                    true,
                    passedPhoneNumber,
                    currentCountryCode.toInt()
                )
            )
            false -> _otpSend.postValue(SendResult(false))
        }
    }

    private fun handleOTPSendError(throwable: Throwable) {
        _loading.postValue(false)
        _otpSend.postValue(SendResult(false))
    }


    //endregion

    //region Country Picker

    var currentCountryCode = DEFAULT_COUNTRY_CODE

    fun onCountryCodeChanged(countryCode: String) {
        currentCountryCode = countryCode
    }

    //endregion
}
//region Send Result

data class SendResult(
    val completed: Boolean,
    val phoneNumber: String = String.NONE,
    val countryCode: Int = 0
)

//endregion