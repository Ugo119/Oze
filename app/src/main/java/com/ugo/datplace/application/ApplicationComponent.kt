package com.ugo.datplace.application

import co.windly.limbo.dagger.scope.ApplicationScope
import com.ugo.datplace.MainModule
import com.ugo.datplace.domain.DomainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(
    dependencies = [DomainComponent::class],
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        MainModule::class,
    ]
)
interface ApplicationComponent: AndroidInjector<Oze> {

    //region Component Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun seedInstance(application: Oze): Builder

        fun seedInstance(component: DomainComponent): Builder

        fun build(): ApplicationComponent
    }
}