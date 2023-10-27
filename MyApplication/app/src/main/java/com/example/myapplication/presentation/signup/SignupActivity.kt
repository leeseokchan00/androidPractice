package com.example.myapplication.presentation.signup

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding
import model.UserData

class SignupActivity : AppCompatActivity() {
    private val viewmodel by viewModels<SignupViewModel>() // SinupViewmodel 객체 생성
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        finishSignup()
    }

    fun finishSignup(){
        binding.btRegSubmit.setOnClickListener {

            val use = UserData (
                binding.etRegId.text.toString(),
                binding.etRegPw.text.toString()
            )

            val sharedPreference = getSharedPreferences("signup", MODE_PRIVATE)
            // name을 가진 sharePreferences 객체 생성, MODE_PRIVATE: 이 APP에서만 사용
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            // 저장하기 위해 Editor 인스턴스가 필요
            editor.putString("user",use.toString())
            editor.putString("id",binding.etRegId.text.toString())  // id라는 key값으로 저장
            editor.putString("pw",binding.etRegPw.text.toString())
            editor.commit()  //저장

            finish()
        }
    }
}

