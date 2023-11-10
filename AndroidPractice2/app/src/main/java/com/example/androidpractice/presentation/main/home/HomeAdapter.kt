package com.example.androidpractice.presentation.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemRecyclerViewBinding
import com.example.androidpractice.model.RecyclerData

class HomeAdapter(
    private val onLongClicked: (RecyclerData) -> Unit,
    private val onClicked: (RecyclerData) -> Unit
) : ListAdapter<RecyclerData, HomeViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        // viewholder가 없다면 viewholder 생성
        //return HomeViewHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return HomeViewHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            onLongClicked,
            onClicked)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        // 생성된 viewholder에 데이터를 binding 해줌
        holder.bind(currentList[position])
    }



    //diffutil사용하려면 diffutil.callback이라는 기능을 구현해야함
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecyclerData>() {
            override fun areItemsTheSame(oldItem: RecyclerData, newItem: RecyclerData): Boolean {
                return oldItem.name == newItem.name }
            //  아이템이 같은 객체인지 여부를 반환

            override fun areContentsTheSame(oldItem: RecyclerData, newItem: RecyclerData): Boolean {
                return oldItem == newItem }
            // 아이템이 같은 데이터를 가지고 있는지 여부를 반환, areItemsTheSame이 true일때만 호출됨
        }
    }
}