package com.ugo.oze.presentation

import androidx.lifecycle.ViewModelProvider
import co.windly.limbo.dagger.lifecycle.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class PresentationModule {
    //region View Model Factory

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    //endregion
}