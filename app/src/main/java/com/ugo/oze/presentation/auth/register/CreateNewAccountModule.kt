package com.ugo.oze.presentation.auth.register

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class CreateNewAccountModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateAccountViewModel::class)
    abstract fun bindCreateNewAccountViewModel(
        viewModel: CreateAccountViewModel
    ): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeCreateNewAccountFragment(): CreateAccountFragment
}
