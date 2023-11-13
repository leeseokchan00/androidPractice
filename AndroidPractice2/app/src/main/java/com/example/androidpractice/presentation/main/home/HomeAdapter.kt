package com.example.androidpractice.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.androidpractice.databinding.ItemRecyclerViewBinding
import com.example.androidpractice.model.FriendData

class HomeAdapter(
    private val onLongClicked: (FriendData) -> Unit,
    private val onClicked: (FriendData) -> Unit
) : ListAdapter<FriendData, HomeViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onLongClicked,
            onClicked
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FriendData>() {
            override fun areItemsTheSame(oldItem: FriendData, newItem: FriendData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FriendData, newItem: FriendData): Boolean {
                return oldItem == newItem
            }
        }
    }
}