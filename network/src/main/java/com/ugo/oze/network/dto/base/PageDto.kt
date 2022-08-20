package com.ugo.oze.network.dto.base

import com.google.gson.annotations.SerializedName

data class PageDto<T: Any>(
    //region Content

    @SerializedName("items")
    var items: List<T> = mutableListOf(),

    //endregion

    //region Meta

    @SerializedName("meta")
    var meta: MetaDto = MetaDto(),

    //endregion

)