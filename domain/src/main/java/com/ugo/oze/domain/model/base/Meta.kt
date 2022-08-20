package com.ugo.oze.domain.model.base

import co.windly.limbo.utility.mapping.LimboPageMetadata

data class Meta(
//
//    var itemsPerPage: Int = 0,
//
//    var incomplete_results: Boolean = false,
//
//    var totalPages: Long = 0,

    var total_count: Long = 0,

    var currentPage: Long = 0

) : LimboPageMetadata<Long>() {

    override val isNextAvailable: Boolean
        get() = currentPage != total_count

    override val nextIdentifier: Long
        get() = ++currentPage

//    fun getAbsoluteIndex(arrayIndex : Int) =
//        (currentPage - 1) * itemsPerPage + arrayIndex
}
