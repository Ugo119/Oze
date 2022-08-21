package com.ugo.oze.network.dto.base

import co.windly.limbo.utility.primitives.ZERO
import com.google.gson.annotations.SerializedName

data class PageDto<T: Any>(
    //region Content

    @SerializedName("items")
    var items: List<T> = mutableListOf(),

    //endregion

    //region Total Count

    @SerializedName("total_count")
    var total_count: Long = Long.ZERO,

    //endregion

    // region Next Page

    val nextPage: Long = Long.ZERO

    // endregion



)