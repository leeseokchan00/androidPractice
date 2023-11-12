package com.example.androidpractice.presentation.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivitySignupBinding
import com.example.androidpractice.model.UserData

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSignupBtnClickListener()
    }

    fun initSignupBtnClickListener() {
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