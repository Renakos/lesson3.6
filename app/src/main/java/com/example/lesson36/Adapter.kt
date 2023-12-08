package com.example.lesson36

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson36.databinding.ItemMyModelBinding

class Adapter(private val data: List<MyModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMyModelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyModel) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMyModelBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
