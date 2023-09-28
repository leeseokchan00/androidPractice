package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : ComponentActivity() {
    lateinit var binding1: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding1.root)


        binding1.btRegSubmit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("userId", binding1.etRegId.text.toString())
            intent.putExtra("userPw", binding1.etRegPw.text.toString())

            startActivity(intent)
            finish()
        }
    }
}

