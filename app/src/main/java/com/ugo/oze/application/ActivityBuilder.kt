package com.ugo.oze.application

import com.ugo.oze.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindMainActivity(): MainActivity
}