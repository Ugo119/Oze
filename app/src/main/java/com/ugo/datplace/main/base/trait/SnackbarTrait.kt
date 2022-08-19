package com.ugo.datplace.main.base.trait

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.ugo.datplace.R

interface SnackbarTrait {

    //region View

    var snackbarTrait: View?

    val snackbarTraitViewId: Int
        get() = R.id.rootView

    //endregion

    //region Common

    fun showErrorMessage(message: String?) =
        showLongSnackbar(message)

    fun showTodoMessage() =
        showLongSnackbar(R.string.common_todo)

    fun showTryAgainErrorMessage() =
        showLongSnackbar(R.string.common_error_try_again_later)

    //endregion

    //region Long

    fun showLongSnackbar(text: CharSequence?) {

        // Do nothing if there is no message.
        text ?: return

        // Do nothing if there is no message view.
        snackbarTrait ?: return

        // Show to be implemented message.
        Snackbar
            .make(requireNotNull(snackbarTrait), text, Snackbar.LENGTH_LONG)
            .show()
    }

    fun showLongSnackbar(@StringRes resId: Int?) {

        // Do nothing if there is no message.
        resId ?: return

        // Do nothing if there is no message view.
        snackbarTrait ?: return

        // Show to be implemented message.
        Snackbar
            .make(requireNotNull(snackbarTrait), resId, Snackbar.LENGTH_LONG)
            .show()
    }

    //endregion

    //region Short

    fun showShortSnackbar(text: CharSequence?) {

        // Do nothing if there is no message.
        text ?: return

        // Do nothing if there is no message view.
        snackbarTrait ?: return

        // Show to be implemented message.
        Snackbar
            .make(requireNotNull(snackbarTrait), text, Snackbar.LENGTH_SHORT)
            .show()
    }

    fun showShortSnackbar(@StringRes resId: Int?) {

        // Do nothing if there is no message.
        resId ?: return

        // Do nothing if there is no message view.
        snackbarTrait ?: return

        // Show to be implemented message.
        Snackbar
            .make(requireNotNull(snackbarTrait), resId, Snackbar.LENGTH_SHORT)
            .show()
    }

    //endregion
}
