package com.example.myapplication.presentation.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding
import model.UserData

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        finishSignup()
    }

    fun finishSignup(){
        binding.btRegSubmit.setOnClickListener {

            val user = UserData(
                binding.etRegId.text.toString(),
                binding.etRegPw.text.toString()
            )

            intent.putExtra("user", user)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}

