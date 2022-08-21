package com.ugo.oze.main.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import co.windly.limbo.mvvm.fragment.DaggerMvvmFragment
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseFragment<Binding : ViewDataBinding, VM : LimboViewModel> :
    DaggerMvvmFragment<Binding, VM>(), HasAndroidInjector {

    //region Activity Injector

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        activityInjector

    //endregion

    //region Lifecycle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Search for snackbar trait view.
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

        // Dispose network stet observer.
        networkStateDisposable?.dispose()
    }

    //endregion

    //region Network State

    private var networkStateDisposable: Disposable? =
        null

    //endregion

    override fun setRetainInstance(retain: Boolean) {
        super.setRetainInstance(false)
    }
}
