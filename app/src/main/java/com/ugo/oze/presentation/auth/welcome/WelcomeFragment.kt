package com.ugo.oze.presentation.auth.welcome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.ugo.oze.R
import com.ugo.oze.databinding.FragmentWelcomeBinding
import com.ugo.oze.main.base.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(),
    WelcomeScreenTrait {

    //region UI

    override val layoutRes: Int
        get() = R.layout.fragment_welcome

    //endregion

    //region View Model

    override val viewModel: WelcomeViewModel
            by viewModels { factory }

    //endregion

    //region Binding

    override fun bindView(binding: FragmentWelcomeBinding) {
        binding
            .also { it.disposables = disposables }
            .also { it.viewModel = viewModel }
        initObservers()
    }

    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    //region Observers

    private fun initObservers() {
        viewModel
            .createAccountClicked
            .observe(viewLifecycleOwner, ::navigateToCreateYourAccount)

        viewModel
            .loginClicked
            .observe(viewLifecycleOwner, ::navigateToLogin)
    }

    //endregion

}
