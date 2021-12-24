package com.jmb.marvelapp.ui.character

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.databinding.ItemSerieBinding
import com.jmb.marvelapp.ui.common.BaseViewHolder
import com.jmb.marvelapp.ui.common.loadUrl

class CharacterAdapter :
    ListAdapter<Character, BaseViewHolder<*>>(
        SerieDiffCallback
    ) {

    companion object {
        private val SerieDiffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
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
        BaseViewHolder<Character>(binding.root) {
        @SuppressLint("SetTextI18n")
        override fun bind(item: Character, position: Int) {
            binding.title.text = item.name
            val rute = "${item.thumbnail.path}/portrait_incredible.${item.thumbnail.extension}"
            binding.poster.loadUrl(rute)
        }
    }


}