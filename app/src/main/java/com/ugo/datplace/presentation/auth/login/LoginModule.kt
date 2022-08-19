package com.ugo.datplace.presentation.auth.login

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import com.ugo.datplace.presentation.auth.login.LoginFragment
import com.ugo.datplace.presentation.auth.login.LoginViewModel
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
