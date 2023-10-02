package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_fragment1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result1Fragment())
                        .commit()
                }

                R.id.item_fragment2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result2Fragment())
                        .commit()
                }

                R.id.item_fragment3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result1Fragment())
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
