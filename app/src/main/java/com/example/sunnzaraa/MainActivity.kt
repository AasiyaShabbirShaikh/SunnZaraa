package com.example.sunnzaraa

import android.os.Bundle
import android.view.View
import androidx.annotation.GravityInt
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.example.sunnzaraa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//
    private lateinit var navController: NavController
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController

        binding.homeToolbar.iconDrawerMenu.setOnClickListener {
            binding.mainDrawer.openDrawer(GravityCompat.START)
        }

        binding.homeToolbar.iconProfile.setOnClickListener {
            navController.navigate(R.id.profileScreenFragment)
        }

        setUpDrawerLayoutMenu()
        setUpHomeBottomBar()
        setUpToolBarBottomBarVisibility()
    }

    private fun setUpHomeBottomBar(){
        binding.homeBottomBar.apply {
            iconHome.setOnClickListener {
                navController.navigate(R.id.homeScreenFragment)
            }

            iconLibrary.setOnClickListener {
                navController.navigate(R.id.libraryScreenFragment)
            }

            iconSearch.setOnClickListener {
                navController.navigate(R.id.searchScreenFragment)
            }

            iconPremium.setOnClickListener {
                navController.navigate(R.id.premiumScreenFragment)
            }
        }
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
            if(destination.id == R.id.termsPrivacyScreenFragment){
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
            else{
                showMainBottomBar()
                showMainToolbar()
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