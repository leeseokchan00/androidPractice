package com.example.androidpractice.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityMainBinding
import com.example.androidpractice.presentation.main.home.HomeFragment
import com.example.androidpractice.presentation.main.page2.Page2Fragment
import com.example.androidpractice.presentation.main.page3.Page3Fragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_fragment1 -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, HomeFragment())   //replace: 프레그먼트 교체
                        .commit()  //commit(): 현재 상태 적용
                }

                R.id.item_fragment2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Page2Fragment())
                        .commit()
                }

                R.id.item_fragment3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Page3Fragment())
                        .commit()
                }

                R.id.item_fragment4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Page2Fragment())
                        .commit()
                }
            }
            true
        }
    }
}