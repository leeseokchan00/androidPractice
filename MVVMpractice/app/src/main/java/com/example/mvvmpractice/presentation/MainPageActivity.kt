package com.example.mvvmpractice.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmpractice.databinding.ActivityMainpageBinding

class MainPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoginFinish.setOnClickListener {
            finish()
        }
    }
}