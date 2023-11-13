package com.example.androidpractice.presentation.main.home.addfriend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityAddFriendBinding
import com.example.androidpractice.model.FriendData

class AddFriendActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddFriendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFriendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAddFriendBtnClickListener()
    }

    fun initAddFriendBtnClickListener() {
        binding.btAddFriend.setOnClickListener {

            val user = FriendData(
                binding.etAddFriendTime.text.toString(),
                binding.etAddFriendId.text.toString().toInt(),
                binding.etAddFriendName.text.toString()
            )

            intent.putExtra("addFriend", user)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}