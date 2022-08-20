package com.ugo.oze.presentation.auth.login

import androidx.fragment.app.viewModels
import com.ugo.oze.main.base.login.BaseLoginFragment

class LoginFragment : BaseLoginFragment() {

    //region View Model

    override val viewModel: LoginViewModel by viewModels { factory }

    //endregion

    //region Navigation

    override fun navigateToForgotPassword() {
//        fragmentTrait
//            .findNavController()
//            .navigate(NavAuthDirections.actionPasswordInitialize())
    }

    //endregion
}
