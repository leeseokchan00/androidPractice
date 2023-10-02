package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding    //bindng 객체 선언
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    var userId:String = "aaagwgwfq12f"
    var userPw:String = "bf131323t1f"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)     //해당 binding의 root view를 반환 - activity_main

        getResult()
        initSignupBtnClickListener()
        initLoginBtnClickListener(userId, userPw)

    }

    //로그인 버튼
    fun initLoginBtnClickListener(id: String?, pw: String?) {
        binding.btLogin.setOnClickListener {
            if (binding.etId.text.toString() == userId && binding.etPw.text.toString() == userPw) {
                val intent = Intent(this, LoginActivity::class.java)
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
            val intent = Intent(this, RegisterActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
    //registerForActivityResult 콜백
    fun getResult(){
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
            if (result.resultCode == RESULT_OK){
                userId = result.data?.getStringExtra("userId").toString()
                userPw = result.data?.getStringExtra("userPw").toString()
            }
        }
    }
}
