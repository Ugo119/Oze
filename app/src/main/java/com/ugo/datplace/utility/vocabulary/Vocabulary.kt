package com.ugo.datplace.utility.vocabulary


//region Api

typealias UserId = Long

//endregion

//region Domain

typealias Password = String

typealias Username = String

//endregion

//region General

val String.Companion.NONE: String
    get() = ""

val Long.Companion.ZERO: Long
    get() = 0L

fun Long?.orZero(): Long =
    this ?: Long.ZERO

fun Long.isZero(): Boolean =
    this == Long.ZERO

val Float.Companion.ZERO: Float
    get() = 0.0f

//endregion

//region Session

typealias AccessToken = String

typealias DeviceId = String

//endregion
