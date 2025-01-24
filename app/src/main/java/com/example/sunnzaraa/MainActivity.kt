package com.example.sunnzaraa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.example.sunnzaraa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController

        binding.homeToolbar.iconProfile.setOnClickListener {
            navController.navigate(R.id.profileScreenFragment)
        }
        setUpHomeBottomBar()
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
}