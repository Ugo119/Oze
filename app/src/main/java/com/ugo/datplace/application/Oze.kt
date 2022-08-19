package com.ugo.datplace.application

import android.app.Application
import android.content.res.Configuration
import com.google.firebase.inject.Provider
import com.ugo.datplace.domain.DaggerDomainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class Oze: Application(), HasAndroidInjector {
    lateinit var applicationComponent: ApplicationComponent

    //region Activity Injector

//    @Inject
//    lateinit var activityInjector: DispatchingAndroidInjector<Any>



    //endregion

    //region Lifecycle

    override fun onCreate() {
        super.onCreate()

        // Initialize dependency injection.
        initializeDependencyInjection()
    }

    //region Dependency Injection

    fun initializeDependencyInjection() {

        // Initialize domain component.
       val domainComponent = DaggerDomainComponent.builder()
            .seedInstance(this)
            .seedInstance(resources)
            .build()



       /* // Initialize application component.
        DaggerApplicationComponent.builder()
            .seedInstance(this)
            .seedInstance(domainComponent)
            .build()

            // Inject dependencies.
            .also { it.inject(this) }*/

       // Initialize application component.
        DaggerApplicationComponent.builder()
            .seedInstance(this)
            .seedInstance(domainComponent)
            .build()

            // Inject dependencies.
            .also { it.inject(this) }
    }

    //region Activity Injector

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        activityInjector

}