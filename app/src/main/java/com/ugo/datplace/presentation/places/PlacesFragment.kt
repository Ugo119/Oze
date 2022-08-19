package com.ugo.datplace.presentation.places

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ugo.datplace.R
import com.ugo.datplace.databinding.FragmentPlacesBinding
import com.ugo.datplace.main.base.BaseFragment

class PlacesFragment : BaseFragment<FragmentPlacesBinding, PlacesViewModel>(), PlacesTrait {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.fragment_places

  //endregion

  //region View Model

  override val viewModel: PlacesViewModel
    by viewModels { factory }

  //endregion

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    openNavDrawer()
  }

  //region Binding

  override fun bindView(binding: FragmentPlacesBinding) {
    binding
      .also { it.disposables = disposables }
      .also { it.viewModel = viewModel }
  }

  //endregion

  fun openNavDrawer() {
    binding.toolbar.imgUser.setOnClickListener {
      binding.toolbar.imgUser.setOnClickListener {
        openDrawer()
      }
    }
  }
}
