package com.example.myapplication.presentation.main.page1

import androidx.recyclerview.widget.DiffUtil
import model.UserData

object DiffUtilCallBack : DiffUtil.ItemCallback<UserData>() {
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.name == newItem.name
    }
    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem == newItem
    }

}