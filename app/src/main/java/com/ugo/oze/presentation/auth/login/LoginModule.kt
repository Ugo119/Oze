package com.ugo.oze.presentation.auth.login

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    //region Binding

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    //endregion

    //region Contribution

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    //endregion
}
