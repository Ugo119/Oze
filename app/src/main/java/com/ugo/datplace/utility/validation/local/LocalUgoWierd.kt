package com.ugo.datplace.utility.validation.local

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.ugo.datplace.utility.validation.base.BaseUgoWierd
import dagger.Reusable
import javax.inject.Inject

@Reusable
class LocalUgoWierd @Inject constructor(private val resources: LocalResources) : BaseUgoWierd() {

    //region Emptiness

    fun validateEmptiness(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean {

        // Check whether input is not empty.
        val inputNotEmpty =
            input.orEmpty().isNotBlank()

        // Validation failed.
        if (!inputNotEmpty) {
            return invalid(stream, resources.emptyField())
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    //region Min Length

    fun validateMinLength(
        input: String?,
        stream: MutableLiveData<String?>?,
        min: Int
    ): Boolean {

        // Check whether input is not empty.
        // This condition is required to support optional fields.
        val inputNotEmpty =
            input.orEmpty().isNotBlank()

        // Check whether input meet length requirement.
        val inputLongEnough =
            input.orEmpty().length >= min

        // Validation failed.
        if (inputNotEmpty && !inputLongEnough) {
            return invalid(stream, resources.minLength(min))
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    //region Input Starts With Zero

    fun validateNumberFormat(
        input: String?,
        stream: MutableLiveData<String?>?,
    ): Boolean {

        // Check whether input starts with zero.
        val inputError =
            input.orEmpty().startsWith("234")

        // Validation failed.
        if (inputError) {
            return invalid(stream, resources.numberFormatError())
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    //region Username

    fun validateUsernameAvailable(
        input: String?,
        stream: MutableLiveData<String?>?,
        available: Boolean
    ): Boolean {

        // Check whether username is available.
        val usernameAvailable =
            input.orEmpty().isNotBlank() && available

        // Validation failed.
        if (!usernameAvailable) {
            return invalid(stream, resources.usernameNotAvailable())
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    //region Email

    fun validateEmail(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean {

        // Check whether email is valid.
        val emailValid =
            Patterns
                .EMAIL_ADDRESS
                .matcher(input.orEmpty())
                .matches()

        // Validation failed.
        if (!emailValid) {
            return invalid(stream, resources.invalidEmail())
        }

        // Validation passed.
        return valid(stream)
    }

    fun validateEmailAvailable(
        input: String?,
        stream: MutableLiveData<String?>?,
        available: Boolean
    ): Boolean {

        // Check whether email is available.
        val emailAvailable =
            input.orEmpty().isNotBlank() && available

        // Validation failed.
        if (!emailAvailable) {
            return invalid(stream, resources.emailNotAvailable())
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    //region Password

    private object Rules {
        const val PASSWORD_UPPERCASE_PATTERN = "[A-Z]"
    }

    fun validatePasswordCase(
        input: String?,
        stream: MutableLiveData<String?>?
    ): Boolean {

        val passwordValid = Rules.PASSWORD_UPPERCASE_PATTERN.toRegex()

        // Validation failed.
        if (input?.let { passwordValid.containsMatchIn(it) } == false) {
            return invalid(stream, resources.noUpperCaseInPasswordError())
        }

        // Validation passed.
        return valid(stream)
    }

    //endregion

    fun countryCodeCheck(
        input: String?,
        countryCode: String,
        stream: MutableLiveData<String?>?
    ): Boolean {
        if (input?.startsWith(countryCode) == true) {
            return invalid(stream, resources.countryCodeCheckError())
        }

        return valid(stream)
    }
}
