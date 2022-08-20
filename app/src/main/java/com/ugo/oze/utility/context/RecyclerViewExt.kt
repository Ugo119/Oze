package com.ugo.oze.utility.context

import androidx.recyclerview.widget.RecyclerView

//region Recycler View

fun RecyclerView.doOnNextPage(downloadNextPage: () -> Unit) {

    val scrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            // Invoke only if can't scroll.
            if (canScrollVertically(1)) {
                return
            }

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                // Download next page of data.
                downloadNextPage.invoke()
            }
        }
    }
    addOnScrollListener(scrollListener)
}

//endregion
