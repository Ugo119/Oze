package com.ugo.oze.presentation.userdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.ugo.oze.R
import com.ugo.oze.databinding.FragmentPlacesBinding
import com.ugo.oze.databinding.FragmentUserDetailsBinding
import com.ugo.oze.main.base.BaseFragment
import com.ugo.oze.presentation.places.adapter.GithubUserItem

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding, UserDetailsViewModel>(),
  UserDetailsTrait {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_user_details

  //endregion

  //region View Model

  override val viewModel: UserDetailsViewModel
    by viewModels { factory }

  //endregion

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Init observers.
    initObservers()

  }

  //region Binding

  override fun bindView(binding: FragmentUserDetailsBinding) {
    binding
      .also { it.disposables = disposables }
      .also { it.viewModel = viewModel }
  }

  //endregion

  //region Observers

  private fun initObservers() {
  }

  //endregion

//  fun openNavDrawer() {
//    binding.toolbar.imgUser.setOnClickListener {
//      binding.toolbar.imgUser.setOnClickListener {
//        openDrawer()
//      }
//    }
//  }

}
