package com.ugo.oze.presentation.auth.error

import androidx.annotation.StringDef
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.EDUCATION_LEVEL
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.FIRST_NAME
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.LAST_NAME
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.NEXT_EXAM
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.OTP_TOKEN
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.PASSWORD
import com.ugo.oze.presentation.auth.error.RegisterErrorType.Companion.PHONE_NUMBER

@StringDef(
    value = [
        EDUCATION_LEVEL,
        FIRST_NAME,
        LAST_NAME,
        NEXT_EXAM,
        OTP_TOKEN,
        PASSWORD,
        PHONE_NUMBER
    ]
)
@Retention(AnnotationRetention.SOURCE)
annotation class RegisterErrorType {

    companion object {

        //region Fields

        const val EDUCATION_LEVEL = "educationLevel"

        const val FIRST_NAME = "firstName"

        const val LAST_NAME = "lastName"

        const val NEXT_EXAM = "nextExam"

        const val OTP_TOKEN = "otpToken"

        const val PASSWORD = "password"

        const val PHONE_NUMBER = "phoneNumber"

        const val EMAIL = "email"

        //endregion
    }
}
