package com.ugo.oze.utility.validation.local

import android.content.res.Resources
import com.ugo.oze.R
import dagger.Reusable
import javax.inject.Inject

@Reusable
class LocalResources @Inject constructor(private val resources: Resources) {

    //region Local

    fun emptyField(): String =
        resources.getString(R.string.local_error_empty_field)

    fun numberFormatError(): String =
        resources.getString(R.string.local_error_number_format_error)

    fun minLength(min: Int): String =
        resources.getString(R.string.local_error_min_length, min)

    fun usernameNotAvailable(): String =
        resources.getString(R.string.local_error_username_not_available)

    fun invalidEmail(): String =
        resources.getString(R.string.local_error_invalid_email)

    fun emailNotAvailable(): String =
        resources.getString(R.string.local_error_email_not_available)

    fun invalidPassword(): String =
        resources.getString(R.string.local_error_invalid_password)

    fun noUpperCaseInPasswordError(): String =
        resources.getString(R.string.local_error_password_no_upper_case)

    fun countryCodeCheckError(): String =
        resources.getString(R.string.country_code_error)


    //endregion
}
