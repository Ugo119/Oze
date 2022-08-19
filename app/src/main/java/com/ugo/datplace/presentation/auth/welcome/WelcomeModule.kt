package com.ugo.datplace.presentation.auth.welcome

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class WelcomeModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthWelcomeFragment(): WelcomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun bindRegisterFormViewModel(viewModel: WelcomeViewModel): ViewModel
}
