package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼 누르면 리사이클러뷰가 있는 xml로 이동
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
            if (result.resultCode == RESULT_OK){}}
        binding.btLoginRecyclerview.setOnClickListener {
            val intent = Intent(this, ViewRecycler::class.java)
            resultLauncher.launch(intent)
        }

        binding.bnBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_fragment1 -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result1Fragment())
                        .commit()
                }

                R.id.item_fragment2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result2Fragment())
                        .commit()
                }

                R.id.item_fragment3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result1Fragment())
                        .commit()
                }

                R.id.item_fragment4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fg_result, Result2Fragment())
                        .commit()
                }
            }
            true
        }
    }
}
