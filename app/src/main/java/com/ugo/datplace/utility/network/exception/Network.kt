package com.ugo.datplace.utility.network.exception

import co.windly.limbo.utility.network.NetworkException
import com.ugo.datplace.utility.network.exception.definition.BusinessError

/**
 * Raised when server responds with a business error.
 */
data class ApiException(
    var code: Int,
    @BusinessError var errorType: String
) : NetworkException()

class BadRequestException(message: String) : NetworkException(message)

class ServerErrorException(message: String) : NetworkException(message)

class UnauthorizedException : NetworkException()

/**
 * Raised when server responds with a validation field error.
 */
data class ValidationFieldException(
    var code: Int,
    var fieldErrors: List<ValidationFieldError>
) : NetworkException()

data class ValidationException(
    var code: Int,
    override val message: String
) : NetworkException(message)

/**
 * Raised when server responds with 412 version code error
 */
data class VersionCodeException(
    var code: Int,
    override var message: String
) : NetworkException()

data class ResourceNotFoundException(
    val id: Int,
    override val message: String,
) : NetworkException()

//endregion
