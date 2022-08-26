package com.ugo.oze.utility.binding

import android.content.res.ColorStateList
import android.os.Build
import android.view.View
import android.view.View.OnClickListener
import android.widget.AutoCompleteTextView
import android.widget.ProgressBar
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.TextViewCompat
import androidx.databinding.BindingAdapter
import co.windly.limbo.utility.view.changeVisibility
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import com.ugo.oze.R

//region View

@BindingAdapter(
    requireAll = false,
    value = ["visible", "occupying"]
)
fun setVisibility(view: View, visible: Boolean, occupying: Boolean = false) {

    // Load resource based on occupying state.
    val res = when (occupying) {
        true -> View.INVISIBLE
        false -> View.GONE
    }

    // Update view visibility.
    view.changeVisibility(visible, res)
}

@BindingAdapter(
    value = ["background"]
)
fun setBackground(view: View, @ColorRes color: Int) {

    // Update background color.
    view.setBackgroundColor(
        ContextCompat.getColor(view.context, color)
    )
}

@BindingAdapter(
    requireAll = false,
    value = ["applyCircularStyle", "applyStroke"]
)
@Suppress("MagicNumber")
fun setShapeOverlay(view: View, useStyle: Boolean, useStroke: Boolean = false) {
    if (!useStyle) return

    val shapeAppearanceModel = ShapeAppearanceModel.builder(
        view.context,
        0,
        R.style.Ugo_Widget_CircleImageView
    ).build()

    @Suppress("MagicNumber")
    ViewCompat.setBackground(view, MaterialShapeDrawable(shapeAppearanceModel).apply {
        if (useStroke) {
            setStroke(2.0f, ContextCompat.getColor(view.context, R.color.white))
        }
    })
}

@BindingAdapter(
    value = ["backgroundTintColor"]
)
fun setBackgroundTint(view: View, @ColorRes color: Int?) {

    if (color == null) return

    // Update background tint color.
    view.backgroundTintList =
        ColorStateList.valueOf(
            ContextCompat.getColor(view.context, color)
        )
}

//endregion

//region ProgressBar

@RequiresApi(Build.VERSION_CODES.N)
@BindingAdapter(
    value = ["progressValue"]
)
fun setProgress(view: ProgressBar, value: Int) {

    // Update progress value.
    view.setProgress(value, true)
}

@BindingAdapter(
    value = ["progressColor"]
)
fun setProgressColor(view: ProgressBar, @ColorRes color: Int) {

    // Update progress color.
    view.progressTintList = ColorStateList.valueOf(
        ContextCompat.getColor(view.context, color)
    )
}

//endregion

//region TextView

@BindingAdapter(
    value = ["textColor"]
)
fun setTextColor(view: MaterialTextView, @ColorRes color: Int) {

    // Update text color.
    view.setTextColor(
        ContextCompat.getColor(view.context, color)
    )
}

@BindingAdapter(
    value = ["drawableTintColor"]
)
fun setDrawableTintColor(view: MaterialTextView, @ColorRes color: Int) {

    // Update drawable tint color.
    TextViewCompat.setCompoundDrawableTintList(
        view,
        ColorStateList.valueOf(
            ContextCompat.getColor(view.context, color)
        )
    )
}

//endregion

//region AutoCompleteTextView

@BindingAdapter(
    requireAll = false,
    value = ["text", "filter"]
)
fun setText(view: AutoCompleteTextView, text: String, filter: Boolean = false) {

    // Update text.
    view.setText(text, filter)
}

//endregion

// region TextInputLayout

@BindingAdapter(
    value = ["endIconClickListener"]
)
fun setEndIconClickListener(
    view: TextInputLayout,
    clickListener: OnClickListener?
) {
    view.setEndIconOnClickListener(clickListener)
}

// endregion
