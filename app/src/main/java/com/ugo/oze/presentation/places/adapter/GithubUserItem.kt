package com.ugo.oze.presentation.places.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

import com.mikepenz.fastadapter.binding.ModelAbstractBindingItem
import com.ugo.oze.R
import com.ugo.oze.databinding.ItemGithubUserBinding
import com.ugo.oze.domain.model.user.User

class GithubUserItem(
    user: User,
) : ModelAbstractBindingItem<User, ItemGithubUserBinding>(user) {

    //region Initialization

    init {
        // Set identifier
        identifier = model.id
    }

    //endregion

    //region Type

    override val type: Int
        get() = R.id.itemUser

    //endregion

    //region Binding

    override fun bindView(binding: ItemGithubUserBinding, payloads: List<Any>) {
        binding.githubUser.text = this.model.login

        Glide.with(binding.avater)
            .load(this.model.avatar_url)
            .into(binding.avater)
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemGithubUserBinding {
        return ItemGithubUserBinding.inflate(inflater, parent, false)
    }

    //endregion

}
