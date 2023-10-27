package com.example.myapplication.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.main.MainActivity
import com.example.myapplication.presentation.signup.SignupActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding    //bindng 객체 선언
    lateinit var resultLauncher: ActivityResultLauncher<Intent>   //ActivityResultLauncher 사용하기 위해 laucher 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)     //해당 binding의 root view를 반환 - activity_main

        getResult()
        initSignupBtnClickListener()
        initLoginBtnClickListener()

    }

    //로그인 버튼
    fun initLoginBtnClickListener() {
        binding.btLogin.setOnClickListener {
            val sharedPreference = getSharedPreferences("signup", MODE_PRIVATE)
            // 회원가입 페이지에서 저장했던 name과 같은 이름의 sharedPreference
            val ID = sharedPreference.getString("id","123")
            val PW = sharedPreference.getString("pw","123")


            if(binding.etId.text.toString() == ID && binding.etPw.text.toString() == PW){
                val intent = Intent(this, MainActivity::class.java)
                resultLauncher.launch(intent)
                finish()
            }
            else{
                Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //회원가입 버튼
    fun initSignupBtnClickListener() {
        binding.btRegister.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)   //돌아올 activity, 이동할 activity를 넣은 intent
            resultLauncher.launch(intent)   // .launch(intent): intent 실행
        }
    }

    //registerForActivityResult 콜백
    fun getResult(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
        }
    }
}
