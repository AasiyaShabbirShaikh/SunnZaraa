package com.example.sunnzaraa

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.annotation.GravityInt
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.example.sunnzaraa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

    private val isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.dashboard_nav_graph)
        navController.graph = navGraph

        if (isLoggedIn) {
            navController.navigate(R.id.homeGraph)
        } else {
            navController.navigate(R.id.loginGraph)
        }

        setUpToolBarBottomBarVisibility()

        binding.homeToolbar.iconDrawerMenu.setOnClickListener {
            binding.mainDrawer.openDrawer(GravityCompat.START)
        }

        binding.homeToolbar.iconProfile.setOnClickListener {
            navController.navigate(R.id.profileScreenFragment)
        }

        resetBottomBarIconsColor()
        binding.homeBottomBar.iconHome.setColorFilter(ContextCompat.getColor(binding.homeBottomBar.iconHome.context, R.color.white), PorterDuff.Mode.SRC_IN)

        setUpDrawerLayoutMenu()
        setUpHomeBottomBar()
    }

    private fun setUpHomeBottomBar(){
        binding.homeBottomBar.apply {

            iconHome.setOnClickListener {
                resetBottomBarIconsColor()
                navController.navigate(R.id.homeScreenFragment)
                iconHome.setColorFilter(ContextCompat.getColor(iconHome.context, R.color.white), PorterDuff.Mode.SRC_IN)
            }

            iconLibrary.setOnClickListener {
                resetBottomBarIconsColor()
                navController.navigate(R.id.libraryScreenFragment)
                iconLibrary.setColorFilter(ContextCompat.getColor(iconLibrary.context, R.color.white), PorterDuff.Mode.SRC_IN)
            }

            iconSearch.setOnClickListener {
                resetBottomBarIconsColor()
                navController.navigate(R.id.searchScreenFragment)
                iconSearch.setColorFilter(ContextCompat.getColor(iconSearch.context, R.color.white), PorterDuff.Mode.SRC_IN)
            }

            iconPremium.setOnClickListener {
                resetBottomBarIconsColor()
                navController.navigate(R.id.premiumScreenFragment)
                iconPremium.setColorFilter(ContextCompat.getColor(iconPremium.context, R.color.white), PorterDuff.Mode.SRC_IN)
            }
        }
    }

    private fun resetBottomBarIconsColor(){
        val defaultColor = ContextCompat.getColor(this, R.color.charcoal)
        binding.homeBottomBar.iconHome.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
        binding.homeBottomBar.iconLibrary.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
        binding.homeBottomBar.iconSearch.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
        binding.homeBottomBar.iconPremium.setColorFilter(defaultColor, PorterDuff.Mode.SRC_IN)
    }

    private fun setUpDrawerLayoutMenu(){
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer, R.string.start, R.string.close)
        binding.mainDrawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.drawerNavView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.music_languages -> {
                    binding.mainDrawer.closeDrawer(GravityCompat.START)
                    navController.navigate(R.id.musicLanguagesScreenFragment)
                }

                R.id.account_settings -> {
                    binding.mainDrawer.closeDrawer(GravityCompat.START)
                    navController.navigate(R.id.settingsScreenFragment)
                }

                R.id.terms_privacy -> {
                    binding.mainDrawer.closeDrawer(GravityCompat.START)
                    navController.navigate(R.id.termsPrivacyScreenFragment)
                }

                R.id.help_faq -> {
                    binding.mainDrawer.closeDrawer(GravityCompat.START)
                    navController.navigate(R.id.helpFaqScreenFragment)
                }
            }
            true
        }

    }

    private fun setUpToolBarBottomBarVisibility(){
        navController.addOnDestinationChangedListener{ _,destination, _ ->
            if(destination.id == R.id.loginScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.registrationScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.createPasswordScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.personalDetailsScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.termsConditionsScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.termsPrivacyScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if (destination.id == R.id.helpFaqScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if (destination.id == R.id.profileScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if (destination.id == R.id.editProfileScreenFragment){
                hideMainToolbar()
                hideMainBottomBar()
            }
            else if(destination.id == R.id.homeScreenFragment){
                binding.root.postDelayed({
                    showMainToolbar()
                    showMainBottomBar()
                }, 50)
            }
            else{
                showMainToolbar()
                showMainBottomBar()
            }
        }
    }

    private fun hideMainBottomBar(){
        binding.bottomBarLayout.visibility = View.GONE
    }

    private fun showMainBottomBar(){
        binding.bottomBarLayout.visibility = View.VISIBLE
    }

    private fun hideMainToolbar(){
        binding.homeToolbarLayout.visibility = View.GONE
    }

    private fun showMainToolbar(){
        binding.homeToolbarLayout.visibility = View.VISIBLE
    }


}