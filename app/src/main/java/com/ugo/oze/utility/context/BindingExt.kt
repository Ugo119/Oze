package com.ugo.oze.utility.context

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.mikepenz.fastadapter.binding.BindingViewHolder

//region Binding

inline fun <reified T : ViewBinding> RecyclerView.ViewHolder.asBinding(): T? =
    when (this is BindingViewHolder<*> && binding is T) {
        true -> binding as T
        false -> null
    }

//endregion