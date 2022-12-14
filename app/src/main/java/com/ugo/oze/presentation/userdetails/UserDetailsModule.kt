package com.ugo.oze.presentation.userdetails

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class UserDetailsModule {

  //region Binding

  @Binds
  @IntoMap
  @ViewModelKey(UserDetailsViewModel::class)
  abstract fun bindPlacesViewModel(viewModel: UserDetailsViewModel): ViewModel

  //endregion

  // region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): UserDetailsFragment

  // endregion
}