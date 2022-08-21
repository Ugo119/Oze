package com.ugo.oze

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ugo.oze.databinding.ActivityMainBinding
import com.ugo.oze.main.base.BaseActivity
import dagger.android.HasAndroidInjector

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainTrait, HasAndroidInjector{

    //region View Model

     override val viewModel: MainViewModel
            by viewModels { factory }

    //endregion

    //region Ui

    override val layoutResId: Int
        get() = R.layout.activity_main

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        // Search for navigation host fragment.
        val host = supportFragmentManager
            .findFragmentById(R.id.appNavHostFragment) as NavHostFragment

        // Find nav controller.
        navigationController = host.navController

        // Init Navigation drawer
        initializeNavigationDrawer()

        // Init bottom navigation bar.
        initializeBottomNavBar()

        // Initialize Observers
        initObservers()

    }

    //endregion

    // region Observers

    private fun initObservers() {
    }

    // endregion

    // region Navigation Drawer

    private fun initializeNavigationDrawer() {
        // Initialize Navigation Drawer
        binding.navView.setupWithNavController(navigationController)

        // Disable icon tints.
        binding.navView.itemIconTintList = null

    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    // endregion

    //region Navigation Controller

    private lateinit var navigationController: NavController

    //endregion

    //region Bottom Navigation Bar

    var lastDestinationId = -1

    private val bottomNavFragments = listOf(
        R.id.placesFragment,
        R.id.favoritesFragment,
    )

    private fun initializeBottomNavBar() {
        // Initialize bottom navigation.
        binding.bottomNavigationView
            .setupWithNavController(navigationController)

        navigationController.addOnDestinationChangedListener { _, destination, _ ->

            // Save last destination.
            lastDestinationId = destination.id

            // Should show bottom navigation
            val shouldShowBottomNav =
                bottomNavFragments.contains(destination.id)

            // Switch bottom navigation visibility.
            if (shouldShowBottomNav) {
                showBottomNavAndUnlockNavDrawer()
            } else {
                hideBottomNavAndLockNavDrawer()
            }
        }
    }

    private fun showBottomNavAndUnlockNavDrawer() {
        // Show Bottom Bar
        binding.bottomNavigationView.visibility = View.VISIBLE

        // Unlock Navigation Drawer
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    private fun hideBottomNavAndLockNavDrawer() {
        // Hide Bottom Bar
        binding.bottomNavigationView.visibility = View.GONE

        // Lock Navigation Drawer
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    //endregion

}