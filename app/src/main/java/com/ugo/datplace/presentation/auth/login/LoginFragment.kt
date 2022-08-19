package com.ugo.datplace.presentation.auth.login

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ugo.datplace.main.base.login.BaseLoginFragment

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
