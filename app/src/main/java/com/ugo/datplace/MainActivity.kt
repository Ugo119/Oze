package com.ugo.datplace

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ugo.datplace.databinding.ActivityMainBinding
import com.ugo.datplace.main.base.BaseActivity
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

        // Initialize Observers
        initObservers()

        getUserLocation()

    }

    //endregion

    // region Observers

    private fun initObservers() {
    }

    // endregion

    //region Bottom Navigation Bar

   /* private fun initializeBottomNavBar() {
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
    }*/

    private fun showBottomNavAndUnlockNavDrawer() {
        // Show Bottom Bar
//        binding.bottomNavigationView.visibility = View.VISIBLE
//
//        if (!viewModel.isExploreMode) {
//            // Unlock Navigation Drawer
//            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//        }
    }

    private fun hideBottomNavAndLockNavDrawer() {
        // Hide Bottom Bar
//        binding.bottomNavigationView.visibility = View.GONE
//
//        // Lock Navigation Drawer
//        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    //endregion

    // region Navigation Drawer

    private fun initializeNavigationDrawer() {
        // Initialize Navigation Drawer
        binding.navView.setupWithNavController(navigationController)

        // Disable icon tints.
        binding.navView.itemIconTintList = null

        // Show chevron right icon for all nav menu items
//        (0 until binding.navView.menu.size()).forEach {
//            binding.navView.menu.getItem(it)
//                .setActionView(R.layout.nav_drawer_item_action_view)
//        }

    }

    fun getUserLocation() {
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                    Log.e("MAINACTIVITY", "Fine Location Selected")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // Only approximate location access granted.
                    Log.e("MAINACTIVITY", "Coarse Location Selected")
                } else -> {
                // No location access granted.
            }
            }
        }

// ...

// Before you perform the actual permission request, check whether your app
// already has the permissions, and whether your app needs to show a permission
// rationale dialog. For more details, see Request permissions.
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    // endregion

    //region Navigation Controller

    private lateinit var navigationController: NavController

    //endregion

}