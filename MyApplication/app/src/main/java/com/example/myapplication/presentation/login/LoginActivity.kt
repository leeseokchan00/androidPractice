package com.example.myapplication.presentation.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.presentation.main.MainActivity
import com.example.myapplication.presentation.signup.SignupActivity
import model.UserData

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding    //bindng 객체 선언
    lateinit var resultLauncher: ActivityResultLauncher<Intent>   //ActivityResultLauncher 사용하기 위해 laucher 선언
    private val viewmodel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)     //해당 binding의 root view를 반환 - activity_main

        getResult() // intent받아와서 로그인
        initSignupBtnClickListener() //회원가입
        autoLogin()

        viewmodel.loginState.observe(this){
            if (viewmodel.loginState.value==true){
                val intent = Intent(this, MainActivity::class.java)
                resultLauncher.launch(intent)
                finish()
            }
        }
    }

    //registerForActivityResult 콜백
    fun getResult(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
            if(result.resultCode== RESULT_OK){
                val user = result.data?.getParcelableExtra("user", UserData::class.java)
                initLoginBtnClickListener(user)// 로그인
            }
        }
    }

    //로그인 버튼
    fun initLoginBtnClickListener(user:UserData?) {
        binding.btLogin.setOnClickListener {
            if(binding.etId.text.toString()==user?.id && binding.etPw.text.toString()==user?.pw){

                val sharedpreferences = getSharedPreferences("loginState", AppCompatActivity.MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedpreferences.edit()
                editor.putBoolean("true", true) //자동로그인 상태 true
                editor.commit()


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

    fun autoLogin(){
        val sharedpreferences = getSharedPreferences("loginState", MODE_PRIVATE)
        if(sharedpreferences.getBoolean("true",false)){
            viewmodel.LoginStateChange()
        }
        else{
            getResult()
        }
    }
}