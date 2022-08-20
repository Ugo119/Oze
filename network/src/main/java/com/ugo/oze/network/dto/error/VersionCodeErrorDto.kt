package com.edukoya.app.network.dto.error

import co.windly.limbo.utility.primitives.EMPTY
import co.windly.limbo.utility.primitives.ZERO
import com.google.gson.annotations.SerializedName

data class VersionCodeErrorDto (

    @SerializedName("statusCode")
    var code: Int = Int.ZERO,

    @SerializedName("message")
    var message: String = String.EMPTY

)