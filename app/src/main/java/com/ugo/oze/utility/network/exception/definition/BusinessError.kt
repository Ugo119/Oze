package com.ugo.oze.utility.network.exception.definition

import androidx.annotation.StringDef
import com.ugo.oze.utility.network.exception.definition.BusinessError.Companion.PHONE_NUMBER_VERIFICATION_FAILED
import com.ugo.oze.utility.network.exception.definition.BusinessError.Companion.USER_ACCOUNT_DISABLED
import com.ugo.oze.utility.network.exception.definition.BusinessError.Companion.USER_ACCOUNT_LOCKED
import com.ugo.oze.utility.network.exception.definition.BusinessError.Companion.USER_ACCOUNT_NOT_ACTIVATED

@StringDef(
    value = [
        USER_ACCOUNT_LOCKED,
        USER_ACCOUNT_DISABLED,
        USER_ACCOUNT_NOT_ACTIVATED,
        PHONE_NUMBER_VERIFICATION_FAILED
    ]
)
@Retention(AnnotationRetention.SOURCE)
annotation class BusinessError {

    companion object {

        //region Login

        const val USER_ACCOUNT_LOCKED = "USER_ACCOUNT_LOCKED"

        const val USER_ACCOUNT_DISABLED = "USER_ACCOUNT_DISABLED"

        const val USER_ACCOUNT_NOT_ACTIVATED = "USER_ACCOUNT_NOT_ACTIVATED"

        //endregion

        //region Register

        const val PHONE_NUMBER_VERIFICATION_FAILED = "PHONE_NUMBER_VERIFICATION_FAILED"

        //endregion
    }
}

