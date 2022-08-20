package com.ugo.oze.application

import co.windly.limbo.dagger.scope.ApplicationScope
import com.ugo.oze.MainModule
import com.ugo.oze.domain.DomainComponent
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