package com.ugo.datplace.main.base

import android.content.Intent
import androidx.annotation.IdRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import co.windly.limbo.mvvm.activity.DaggerMvvmActivity
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import com.ugo.datplace.R
import dagger.android.HasAndroidInjector

abstract class BaseActivity<Binding : ViewDataBinding, VM : LimboViewModel> :
    DaggerMvvmActivity<Binding, VM>() {

    //region Binding

    override fun bindView(binding: Binding) = Unit

    //endregion

    //region Lifecycle

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        // Handle deep link.
        navigationController?.handleDeepLink(intent)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()

    }

    //endregion

    //region Navigation Controller

    @get:IdRes
    val navFragment: Int = R.id.appNavHostFragment

    private var navigationController: NavController? = null

    @Suppress("UnusedPrivateMember")
    private fun initializeNavigationController() {

        // Search for navigation host fragment.
        val host = supportFragmentManager
            .findFragmentById(R.id.appNavHostFragment) ?: return

        // Find nav controller.
        navigationController =
            (host as NavHostFragment).navController
    }

    //endregion


}