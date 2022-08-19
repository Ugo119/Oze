package com.ugo.datplace.utility.network.exception

class ValidationError<T : Any?> {

    //region Companion

    companion object {

        /**
         * Common instance for empty validation error.
         */
        val EMPTY: ValidationError<Any?> = ValidationError()

        /**
         * Returns an empty validation error instance. No value is present for this
         * validation error.
         */
        fun <T : Any?> empty(): ValidationError<T> =
            EMPTY as ValidationError<T>

        /**
         * Returns a validation error with the specified present non-nullable value.
         */
        fun <T : Any?> of(value: T): ValidationError<T> =
            ValidationError(value)

        /**
         * Returns a validation error describing the specified value, if non-null,
         * otherwise returns an empty validation error.
         */
        fun <T : Any?> ofNullable(value: T?): ValidationError<T?> =
            if (value == null) empty() else of(value)
    }

    //endregion

    //region Constructor

    /**
     * Constructs an empty instance.
     */
    private constructor() {
        value = null
    }

    /**
     * Constructs a validation error with the specified present non-null value.
     */
    private constructor(value: T) {
        this.value = value
    }

    //endregion

    //region Value

    private var value: T?

    /**
     * If a value is present in this validation error, returns this value,
     * otherwise throws {@code IllegalArgumentException}.
     */
    fun get(): T {

        // Throw an exception in case if no value is present.
        if (value == null) {
            throw IllegalArgumentException("No value present.")
        }

        // Return non-null value if present.
        return value!!
    }
}
