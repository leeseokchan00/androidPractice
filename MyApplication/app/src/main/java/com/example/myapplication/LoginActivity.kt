package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.databinding.ActivityLoginBinding


class LoginActivity : FragmentActivity() {
    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btFg1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fg_result, Result1Fragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btFg2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fg_result, Result2Fragment())
                .addToBackStack(null)
                .commit()
        }
    }
}