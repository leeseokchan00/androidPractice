package com.example.mvvmpractice.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.R
import com.example.mvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val viewmodel by viewModels<UserViewModel>()
    // viewModel 객체 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //데이터 바인딩 : xml을 사용하기 위한 객체 반환

        viewmodel.login.observeForever {
        }
        //observer를 연결해서 LiveData를 관찰

        getResult()
        ClickSignup()

        val sharedpreferences = getSharedPreferences("signup", MODE_PRIVATE)
        if(sharedpreferences.getBoolean("loginState",false)==true){
            val intent = Intent(this, MainPageActivity::class.java)
            resultLauncher.launch(intent)
            finish()
        }
        else{
            ClickLogin()
        }
    }
    fun ClickSignup(){
        binding.btSignup.setOnClickListener {
            val sharedpreferences = getSharedPreferences("signup", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedpreferences.edit()
            editor.putString("id", binding.etSignupId.text.toString())
            editor.putString("pw", binding.etSignupPw.text.toString())
            editor.putBoolean("loginState", true)
            editor.commit()
        }
    }
    fun ClickLogin(){
        binding.btLogin.setOnClickListener {
            val sharedpreferences = getSharedPreferences("signup", MODE_PRIVATE)
            if(sharedpreferences.getString("id",null)==binding.etLoginId.text.toString()&&
                sharedpreferences.getString("pw",null)==binding.etLoginPw.text.toString()){

                val intent = Intent(this, MainPageActivity::class.java)
                resultLauncher.launch(intent)
                finish()
            }

        }
    }
    fun getResult(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
        }
    }
}

