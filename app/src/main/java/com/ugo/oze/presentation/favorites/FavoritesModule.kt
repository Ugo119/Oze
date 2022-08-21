package com.ugo.oze.presentation.favorites

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FavoritesModule {

  //region Binding

  @Binds
  @IntoMap
  @ViewModelKey(FavoritesViewModel::class)
  abstract fun bindPlacesViewModel(viewModel: FavoritesViewModel): ViewModel

  //endregion

  // region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): FavoritesFragment

  // endregion
}