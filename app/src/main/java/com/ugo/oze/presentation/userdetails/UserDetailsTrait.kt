package com.ugo.oze.presentation.userdetails

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import co.windly.limbo.mvvm.trait.FragmentTrait
import com.ugo.oze.MainActivity
import com.ugo.oze.NavMainDirections
import com.ugo.oze.domain.model.user.User

//region Places

interface UserDetailsTrait: PracticeDrawerTrait
//FragmentTrait
interface PracticeDrawerTrait : FragmentNavigationTrait {

    fun openDrawer() {
        (fragmentTrait.activity as? MainActivity)?.openDrawer()
    }

    override fun navigateUp() {

        // Pop current fragment.
        navigationTrait
            .findNavController()
            .navigateUp()
    }

}

//endregion