package com.edukoya.app.utility.network.definition

import androidx.annotation.StringDef
import com.edukoya.app.utility.network.definition.ValidationError.Companion.REQUIRED

@StringDef(
    value = [
        REQUIRED
    ]
)
@Retention(AnnotationRetention.SOURCE)
annotation class ValidationError {

    companion object {
        const val REQUIRED = "REQUIRED"
    }
}
