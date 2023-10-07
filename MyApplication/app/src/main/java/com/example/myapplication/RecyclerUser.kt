package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.ItemRecyclerViewBinding

lateinit var binding: ItemRecyclerViewBinding
class RecyclerUser(val itemList: ArrayList<UserData>) :
    RecyclerView.Adapter<RecyclerUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_time.text = itemList[position].time
        holder.tv_title.text = itemList[position].title
        holder.tv_name.text = itemList[position].name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tv_time = itemView.findViewById<TextView>(R.id.tv_recycler_time)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_recycler_title)
        val tv_name = itemView.findViewById<TextView>(R.id.tv_recycler_name)
    }
}
