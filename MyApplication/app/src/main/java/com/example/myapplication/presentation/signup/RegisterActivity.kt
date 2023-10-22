package com.example.myapplication.presentation.signup

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding1: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding1.root)


        binding1.btRegSubmit.setOnClickListener {

            val sharedPreference = getSharedPreferences("signup", MODE_PRIVATE)
            // name을 가진 sharePreferences 객체 생성, MODE_PRIVATE: 이 APP에서만 사용
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            // 저장하기 위해 Editor 인스턴스가 필요
            editor.putString("id",binding1.etRegId.text.toString())  // id라는 key값으로 저장
            editor.putString("pw",binding1.etRegPw.text.toString())
            editor.commit()  //저장

            finish()
        }
    }
}

