package com.example.mvvmpractice.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmpractice.R
import com.example.mvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel1 = UserViewModel()   //view(activity)에서 view model 연결

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 데이터바인딩 setComtentView : xml초기화 하고 그 xml을 이용하기 위한 객체 반환
        binding.viewModel = viewModel1 //view(layout)에서 view model 연결
    }
}