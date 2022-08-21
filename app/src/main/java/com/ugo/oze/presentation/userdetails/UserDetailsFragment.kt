package com.ugo.oze.presentation.userdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.ugo.oze.R
import com.ugo.oze.databinding.FragmentPlacesBinding
import com.ugo.oze.databinding.FragmentUserDetailsBinding
import com.ugo.oze.main.base.BaseFragment
import com.ugo.oze.presentation.places.PlacesFragment
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

  // region args

  val args : UserDetailsFragmentArgs by navArgs()

  // endregion

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Init observers.
    initObservers()

    // Inflate Views
    inflateViews()

    // Setup Toolbar
    setupToolbar()

    // Set User As Favorite
    makeUserFavorite()

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

  // region Inflate Views

  private fun inflateViews() {
    Glide.with(requireContext())
      .load(args.avatar)
      .into(binding.userImage)
    binding.userName.text = args.name
    binding.followers.text = args.followers
    binding.gist.text = args.gist
  }

  // endregion

  // region Mark User As Favorite

  private fun makeUserFavorite() {
    binding.favoriteImage.setOnClickListener {
      viewModel.setUserAsFavorite(args.userId, IS_FAVORITE)

      userSetAsFavoriteSuccess()
    }
  }

  // endregion

  // region User Set As Favorite Success

  private fun userSetAsFavoriteSuccess() {
    Toast.makeText(requireContext(), "${args.name} successfully set as favorite", Toast.LENGTH_LONG)
      .show()
  }

  // endregion

  // region Toolbar

  private fun setupToolbar() {
    binding.toolbar.txtHeader.text = PlacesFragment.APP_NAME
    binding.toolbar.arrowBack.setOnClickListener {
      navigateUp()
    }
  }

  // endregion

  companion object {
    const val IS_FAVORITE = true
  }

}
