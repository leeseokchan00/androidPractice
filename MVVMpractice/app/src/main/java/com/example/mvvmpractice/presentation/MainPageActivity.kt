package com.example.mvvmpractice.presentation

import android.content.Context
import android.content.SharedPreferences
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
            val sharedpreferences = getSharedPreferences("signup", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedpreferences.edit()
            editor.remove("signup")
            editor.clear()
            editor.commit()
        }
    }
}