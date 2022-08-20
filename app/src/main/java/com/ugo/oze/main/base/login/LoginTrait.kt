package com.ugo.oze.main.base.login

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import com.ugo.oze.NavMainDirections

interface LoginTrait :
    LoginNavigationTrait

// region Navigation

interface LoginNavigationTrait : FragmentNavigationTrait {

    fun navigateToForgotPassword()

    fun navigateToDatPlace() {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections.actionPlaces())
    }
}

// endregion
