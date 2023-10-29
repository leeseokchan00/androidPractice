package com.example.myapplication.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.main.page1.Result1Fragment
import com.example.myapplication.presentation.main.page2.Result2Fragment
import com.example.myapplication.presentation.main.page3.Result3Fragment


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
                        .replace(R.id.fg_result, Result1Fragment())   //replace: 프레그먼트 교체
                        .commit()  //commit(): 현재 상태 적용
                }

                R.id.item_fragment2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result2Fragment())
                        .commit()   
                }

                R.id.item_fragment3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result3Fragment())
                        .commit()
                }

                R.id.item_fragment4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result2Fragment())
                        .commit()
                }
            }
            true
        }
    }
}
