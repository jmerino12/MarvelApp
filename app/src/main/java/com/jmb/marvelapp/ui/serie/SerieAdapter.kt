package com.jmb.marvelapp.ui.serie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jmb.domain.aggregates.Serie
import com.jmb.marvelapp.databinding.ItemSerieBinding
import com.jmb.marvelapp.ui.common.BaseViewHolder
import com.jmb.marvelapp.ui.common.loadUrl

class SerieAdapter :
    ListAdapter<Serie, BaseViewHolder<*>>(
        SerieDiffCallback
    ) {

    companion object {
        private val SerieDiffCallback = object : DiffUtil.ItemCallback<Serie>() {
            override fun areItemsTheSame(oldItem: Serie, newItem: Serie): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Serie, newItem: Serie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val viewBinding =
            ItemSerieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return SerieViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = getItem(position)
        when (holder) {
            is SerieViewHolder -> {
                holder.bind(item, position)
            }
        }
    }


    class SerieViewHolder(
        private val binding: ItemSerieBinding
    ) :
        BaseViewHolder<Serie>(binding.root) {
        @SuppressLint("SetTextI18n")
        override fun bind(item: Serie, position: Int) {
            binding.title.text = item.title
            val rute = "${item.thumbnail.path}/portrait_incredible.${item.thumbnail.extension}"
            binding.poster.loadUrl(rute)
        }
    }


}