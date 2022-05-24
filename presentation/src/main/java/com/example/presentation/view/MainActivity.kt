package com.example.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.view.fragment.FreeBoardFragment
import com.example.presentation.view.fragment.InquiryFragment
import com.example.presentation.view.fragment.NoticeFragment
import com.example.presentation.view.fragment.StoryBoardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, FreeBoardFragment().apply {
            arguments = Bundle().apply {
                Log.d("SUCCESS", "onNavigationItemSelected intent extra: ${intent.getIntExtra("userId", 0)}")
                putInt("id", intent.getIntExtra("userId", 0))
            }
        }).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.freeBoard -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, FreeBoardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id", intent.getIntExtra("userId", 0))
                    }
                }).commitAllowingStateLoss()
                return true
            }
            R.id.inquiry -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, InquiryFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id", intent.getIntExtra("userId", 0))
                    }
                }).commitAllowingStateLoss()
                return true
            }
            R.id.notice -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, NoticeFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id", intent.getIntExtra("userId", 0))
                    }
                }).commitAllowingStateLoss()
                return true
            }
            R.id.storyBoard -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, StoryBoardFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id", intent.getIntExtra("userId", 0))
                    }
                }).commitAllowingStateLoss()
                return true
            }
        }
        return false
    }
}