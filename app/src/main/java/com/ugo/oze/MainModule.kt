package com.ugo.oze

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import com.ugo.oze.presentation.PresentationModule
import com.ugo.oze.presentation.auth.login.LoginModule
import com.ugo.oze.presentation.auth.register.CreateNewAccountModule
import com.ugo.oze.presentation.auth.welcome.WelcomeModule
import com.ugo.oze.presentation.places.PlacesModule
import com.ugo.oze.presentation.userdetails.UserDetailsModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PlacesModule::class,
        WelcomeModule::class,
        CreateNewAccountModule::class,
        LoginModule::class,
        PresentationModule::class,
        UserDetailsModule::class

    ]
)
abstract class MainModule {

    //region Binding

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    //endregion

    //region Contribution

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    //endregion

    //region View Model Factory

//    @Binds
//    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    //endregion

}
