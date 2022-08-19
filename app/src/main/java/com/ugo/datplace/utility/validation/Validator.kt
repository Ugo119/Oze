package com.ugo.datplace.utility.validation

import co.windly.limbo.utility.network.NoNetworkException
import co.windly.limbo.utility.network.NoServerException
import com.ugo.datplace.utility.network.exception.ApiException
import com.ugo.datplace.utility.network.exception.BadRequestException
import com.ugo.datplace.utility.network.exception.UnauthorizedException
import com.ugo.datplace.utility.network.exception.ValidationError
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject
import java.net.UnknownHostException

abstract class Validator {
    //region Validation

    open fun validate(throwable: Throwable) {

        // Validate bad request exception.
        validateBadRequestError(throwable)

        // Validate no network exception.
        validateNoNetworkError(throwable)

        // Validate no server exception.
        validateNoServerError(throwable)

        // Validate unauthorized exception.
        validateUnauthorizedError(throwable)

        // Validate api exception.
        if (throwable is ApiException) {
            validateApiError(throwable)
        }
    }

    //endregion

    //region Network Validation

    private val noNetworkSubject: PublishSubject<ValidationError<Boolean>> =
        PublishSubject.create()

    fun noNetworkErrors(): Flowable<ValidationError<Boolean>> =
        noNetworkSubject
            .toFlowable(BackpressureStrategy.LATEST)
            .distinctUntilChanged()

    private fun validateNoNetworkError(throwable: Throwable) {

        // Check if network is not reachable.
        val unreachable = throwable is NoNetworkException

        // Update subject.
        noNetworkSubject.onNext(ValidationError.of(unreachable))
    }

    //endregion

    //region Server Validation

    private val noServerSubject: PublishSubject<ValidationError<Boolean>> =
        PublishSubject.create()

    fun noServerErrors(): Flowable<ValidationError<Boolean>> =
        noServerSubject
            .toFlowable(BackpressureStrategy.LATEST)
            .distinctUntilChanged()

    private fun validateNoServerError(throwable: Throwable) {

        // Check if server is not reachable.
        val unreachable =
            throwable is NoServerException || throwable is UnknownHostException

        // Update subject.
        noServerSubject.onNext(ValidationError.of(unreachable))
    }

    //endregion

    //region Unauthorized

    private val unauthorizedSubject: PublishSubject<ValidationError<Boolean>> =
        PublishSubject.create()

    fun unauthorizedErrors(): Flowable<ValidationError<Boolean>> =
        unauthorizedSubject
            .toFlowable(BackpressureStrategy.LATEST)
            .distinctUntilChanged()

    private fun validateUnauthorizedError(throwable: Throwable) {

        // Check if user is unauthorized.
        val unreachable = throwable is UnauthorizedException

        // Update subject.
        unauthorizedSubject.onNext(ValidationError.of(unreachable))
    }

    //endregion

    //region Bad Request

    private val badRequestSubject: PublishSubject<ValidationError<Boolean>> =
        PublishSubject.create()

    fun badRequestErrors(): Flowable<ValidationError<Boolean>> =
        badRequestSubject
            .toFlowable(BackpressureStrategy.LATEST)
            .distinctUntilChanged()

    private fun validateBadRequestError(throwable: Throwable) {

        // Check if user caught bad request exception.
        val unreachable = throwable is BadRequestException

        // Update subject.
        badRequestSubject.onNext(ValidationError.of(unreachable))
    }

    //endregion

    //region Api Validation

    open fun validateApiError(throwable: ApiException) {

        // Validate non-field errors.
        validateNonFieldErrors(throwable.errorType)
    }

    //endregion

    //region Validation Error

    protected open fun <T> emitError(error: T?, subject: PublishSubject<ValidationError<T?>>) {

        // Create validation error.
        val validated = ValidationError.ofNullable(error)

        // Emit validation error.
        subject.onNext(validated)
    }

    //endregion

    //region Non-Field

    open fun validateNonFieldErrors(errorType: String) {

        // Create and emit validation error.
        emitError(errorType, nonFieldSubject)
    }

    protected open val nonFieldSubject: PublishSubject<ValidationError<String?>> =
        PublishSubject.create()

    fun nonFieldErrors(): Flowable<ValidationError<String?>> =
        nonFieldSubject
            .toFlowable(BackpressureStrategy.LATEST)

    //endregion
}