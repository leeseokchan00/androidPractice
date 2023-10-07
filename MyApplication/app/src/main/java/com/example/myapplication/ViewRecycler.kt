package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.RecyclerViewBinding

class ViewRecycler : AppCompatActivity() {
    lateinit var binding: RecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = ArrayList<UserData>()

        for(i: Int in 1.. 100) {
            itemList.add(UserData("22:01", i.toString(), "이석찬"))
        }
        val boardAdapter = RecyclerUser(itemList)
        boardAdapter.notifyDataSetChanged()
        binding.rvRecycler.adapter = boardAdapter
        binding.rvRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
