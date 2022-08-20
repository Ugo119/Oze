package com.ugo.oze.presentation.auth.welcome

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import com.ugo.oze.NavMainDirections

interface WelcomeScreenTrait :
    WelcomeScreenNavigationTrait


interface WelcomeScreenNavigationTrait : FragmentNavigationTrait {

    fun navigateToCreateYourAccount(value: Boolean) {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections.actionCreateAccount())
    }

    fun navigateToLogin(value: Any) {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections.actionLogin())
    }
}
