package com.ugo.oze.presentation.places.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import com.ugo.oze.databinding.ItemGithubUserBinding
import com.ugo.oze.domain.model.user.User
import com.ugo.oze.utility.context.asBinding

class UsersEventHook(
    private val listener: (User) -> Unit
) : ClickEventHook<GithubUserItem>() {

    //region Bind

    override fun onBind(viewHolder: RecyclerView.ViewHolder): View? =
        viewHolder
            .asBinding<ItemGithubUserBinding>()
            ?.root

    //endregion

    //region Click

    override fun onClick(
        v: View,
        position: Int,
        fastAdapter: FastAdapter<GithubUserItem>,
        item: GithubUserItem
    ) {
        // Invoke listener.
        listener.invoke(item.model)
    }

    //endregion
}