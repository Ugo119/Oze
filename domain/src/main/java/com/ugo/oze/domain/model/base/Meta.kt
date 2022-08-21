package com.ugo.oze.domain.model.base

import co.windly.limbo.utility.mapping.LimboPageMetadata
import co.windly.limbo.utility.primitives.ZERO
import com.google.gson.annotations.SerializedName

data class Meta<T>(

    var items: List<T> = mutableListOf(),

    //endregion

    //region Total Count

    var total_count: Long = Long.ZERO,

    //endregion

    // region Next Page

    var nextPage: Long = Long.ZERO

    // endregion

)
