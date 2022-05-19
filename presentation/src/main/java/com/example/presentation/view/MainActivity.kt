package com.example.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.NbViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nav: BottomNavigationView
    private val mainViewModel by viewModels<NbViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        nav = binding.bottomNavigationView
        setBottomNavi(navHostFragment)
        getUser()
    }

    private fun setBottomNavi(navHost: NavHostFragment) {
        val navController = navHost.navController
        nav.setupWithNavController(navController)
    }

    private fun getUser() {
        val id = intent.getIntExtra("userId", 0)
        mainViewModel.getUserLogic(id)
        mainViewModel.userInfoApiCallResult.observe(this) {
            Log.d("SUCCESS", "getUser it: $it")
        }
    }
}