package com.ugo.oze.presentation.favorites

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import co.windly.limbo.mvvm.trait.FragmentTrait
import com.ugo.oze.MainActivity
import com.ugo.oze.NavMainDirections
import com.ugo.oze.domain.model.user.User

//region Places

interface PlacesTrait: PracticeDrawerTrait
//FragmentTrait
interface PracticeDrawerTrait : FragmentNavigationTrait {

    fun openDrawer() {
        (fragmentTrait.activity as? MainActivity)?.openDrawer()
    }

    fun navigateToUserDetails(user: User) {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections
                .actionUserDetails(
                    user.id,
                    user.avatar_url,
                    user.login,
                    user.followers_url,
                    user.gists_url,
                    user.is_favorite
                )
            )
    }

}

//endregion