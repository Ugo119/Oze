package com.ugo.oze.utility.network.exception

import com.ugo.oze.utility.vocabulary.NONE

data class ValidationFieldError(

    //region Messages

    var messages: List<String> = emptyList(),

    //endregion

    //region Field

    var field: String = String.NONE

    //endregion
)