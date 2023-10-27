package com.example.myapplication.presentation.main.page1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRecyclerViewBinding
import model.RecyclerData

class UserAdapter : ListAdapter<RecyclerData, UserAdapter.ItemViewHolder>(diffUtil) {
// <DataType, 뷰홀더>
    inner class ItemViewHolder(private val binding: ItemRecyclerViewBinding) :
    //뷰홀더 클래스: 재활용 되는 최초의 뷰객체를 기억하고 있는 (홀딩)객체
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bookModel: RecyclerData) {
            binding.tvRecyclerTitle.text = bookModel.title
            binding.tvRecyclerName.text = bookModel.name
            binding.tvRecyclerTime.text = bookModel.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    // viewholder가 없다면 viewholder 생성
        return ItemViewHolder(
            ItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
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