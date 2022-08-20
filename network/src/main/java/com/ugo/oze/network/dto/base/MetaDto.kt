package com.ugo.oze.network.dto.base

import com.google.gson.annotations.SerializedName

data class MetaDto(

//    @SerializedName("totalItems")
//    var totalItems: Int = 0,
//
//    @SerializedName("itemCount")
//    var itemCount: Int = 0,

    @SerializedName("incomplete_results")
    var incomplete_results: Boolean = false,

    @SerializedName("total_count")
    var total_count: Long = 0,

    @SerializedName("currentPage")
    var currentPage: Int = 0
)
