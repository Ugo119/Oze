package com.ugo.datplace.presentation.auth.register

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait

//region Register Form

interface CreateNewAccountTrait :
    CreateNewAccountNavigationTrait

//endregion

//region Register Form - Navigation

interface CreateNewAccountNavigationTrait : FragmentNavigationTrait {

    fun navigateToLogin() {
//        navigationTrait
//            .findNavController()
//            .navigate(NavAuthDirections.actionLogin())
    }

    fun navigateToOTP(phoneNumber: String, countryCode: Int) {
//        navigationTrait
//            .findNavController()
//            .navigate(NavAuthDirections.actionVerifyFragment(phoneNumber, countryCode))
    }
}

//endregion
