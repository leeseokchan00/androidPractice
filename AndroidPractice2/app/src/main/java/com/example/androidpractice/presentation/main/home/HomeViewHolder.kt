package com.example.androidpractice.presentation.main.home

import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemRecyclerViewBinding
import com.example.androidpractice.model.FriendData

class HomeViewHolder(
    private val binding: ItemRecyclerViewBinding,
    private val onLongClicked: (FriendData) -> Unit,
    private val onClicked: (FriendData) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: FriendData) {
        binding.tvRecyclerTitle.text = data.id.toString()
        binding.tvRecyclerName.text = data.name
        binding.tvRecyclerTime.text = data.time

        binding.root.setOnLongClickListener {
            onLongClicked(data)
            return@setOnLongClickListener true
            //이벤트 처리가 완료되면 true, 아니면 false반환
        }
        binding.root.setOnClickListener {
            onClicked(data)
        }
    }
}