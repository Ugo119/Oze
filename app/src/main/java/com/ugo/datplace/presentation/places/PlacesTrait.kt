package com.ugo.datplace.presentation.places

import co.windly.limbo.mvvm.trait.FragmentTrait
import com.ugo.datplace.MainActivity

//region Places

interface PlacesTrait: PracticeDrawerTrait

interface PracticeDrawerTrait : FragmentTrait {

    fun openDrawer() {
        (fragmentTrait.activity as? MainActivity)?.openDrawer()
    }

}

//endregion