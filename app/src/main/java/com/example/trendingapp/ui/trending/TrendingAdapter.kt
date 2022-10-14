package com.example.trendingapp.ui.trending

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trendingapp.R
import com.example.trendingapp.databinding.ItemTrendingBinding

class TrendingAdapter(var context: Context) : RecyclerView.Adapter<TrendingAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingAdapterViewHolder {
        val binding = DataBindingUtil.inflate<ItemTrendingBinding>(
            LayoutInflater.from(context), R.layout.item_trending,
            parent, false
        )
        return TrendingAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return 10
    }

    override fun onBindViewHolder(holder: TrendingAdapterViewHolder, position: Int) {
        holder.bind()
    }

}

class TrendingAdapterViewHolder(var binding: ItemTrendingBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind() {
    }

}

