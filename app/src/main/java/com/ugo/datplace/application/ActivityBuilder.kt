package com.ugo.datplace.application

import com.ugo.datplace.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindMainActivity(): MainActivity
}