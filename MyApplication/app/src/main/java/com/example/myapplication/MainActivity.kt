package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding    //bindng 객체 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)     //해당 binding의 root view를 반환 - activity_main

        val getId = intent.getStringExtra("userId")
        val getPw = intent.getStringExtra("userPw")


        initSignupBtnClickListener()
        initLoginBtnClickListener(getId, getPw)
    }

    //로그인 버튼
    fun initLoginBtnClickListener(getId: String?, getPw: String?) {
        binding.btLogin.setOnClickListener {
            if (binding.etId.text.toString() == getId && binding.etPw.text.toString() == getPw) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    //회원가입 버튼
    fun initSignupBtnClickListener() {
        binding.btRegister.setOnClickListener {
            ////intent는 데이터를 담는 클래스, 컴포넌트들 실행하는 정보
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
