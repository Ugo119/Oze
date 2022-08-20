package com.ugo.oze.presentation.places

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PlacesModule {

  //region Binding

  @Binds
  @IntoMap
  @ViewModelKey(PlacesViewModel::class)
  abstract fun bindPlacesViewModel(viewModel: PlacesViewModel): ViewModel

  //endregion

  // region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): PlacesFragment

  // endregion
}