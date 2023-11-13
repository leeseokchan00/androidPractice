package com.example.androidpractice.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityLoginBinding
import com.example.androidpractice.model.UserData
import com.example.androidpractice.presentation.main.MainActivity
import com.example.androidpractice.presentation.signup.SignupActivity
import com.example.androidpractice.util.getParcelable

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val viewmodel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initResultLaucher()
        initSignupBtnClickListener()
        initLoginBtnClickListener()
        autoLogin()
        initLoginStateObserver()
    }

    fun initResultLaucher() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                viewmodel.setUserData(result.data?.getParcelable("user", UserData::class.java))
            }
        }
    }

    //로그인 버튼
    fun initLoginBtnClickListener() {
        binding.btLogin.setOnClickListener {
            if (viewmodel.getUserData(binding.etId.text.toString(), binding.etPw.text.toString())) {
            } else {
                Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //회원가입 버튼
    fun initSignupBtnClickListener() {
        binding.btRegister.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    fun initLoginStateObserver() {
        viewmodel.loginState.observe(this) {
            if (viewmodel.loginState.value == true) {
                Toast.makeText(this, "로그인 완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                resultLauncher.launch(intent)
                finish()
            }
        }
    }

    fun autoLogin() {
        viewmodel.loginStateChange()
    }
}