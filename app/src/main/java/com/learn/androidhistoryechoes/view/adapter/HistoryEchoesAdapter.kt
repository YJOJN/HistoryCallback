package com.learn.androidhistoryechoes.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.androidhistoryechoes.databinding.ActivityMainBinding
import com.learn.androidhistoryechoes.databinding.ItemHistoryEchoesBinding
import com.learn.androidhistoryechoes.model.Data

class HistoryEchoesAdapter : RecyclerView.Adapter<HistoryEchoesAdapter.ViewHolder>() {
    var mData: List<Data> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var mOnItemHistoryEchoesClickListener: (view: View, model: Data)->Unit = { _, _ -> }
    fun setOnItemHistoryEchoesClickListener(onItemHistoryEchoesClickListener: (view: View, model: Data)->Unit) {
        mOnItemHistoryEchoesClickListener = onItemHistoryEchoesClickListener
    }

    inner class ViewHolder(private val binding: ItemHistoryEchoesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(model: Data) {
            binding.tvYear.text = model.year.toString()
            binding.tvTitle.text = model.title
            binding.root.setOnClickListener {
                mOnItemHistoryEchoesClickListener.invoke(it, model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHistoryEchoesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = mData[position]
        holder.bindData(model)
    }
}