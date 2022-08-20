package com.ugo.oze.utility

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

//region Soft Keyboard

/**
 * Shows soft input keyboard.
 */
fun View.showSoftInput() {
    // Request focus on view first.
    requestFocus()

    // Do nothing if no context found.
    context ?: return

    // Get access to the input method manager.
    val manager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    manager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
//endregion

// region Visibility

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

// endregion