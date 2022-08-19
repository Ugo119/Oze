package com.ugo.datplace.presentation.places

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.windly.limbo.dagger.ViewModelKey
import com.ugo.datplace.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
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