package com.jmb.marvelapp.ui.character

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.databinding.ItemSerieBinding
import com.jmb.marvelapp.ui.common.BaseViewHolder
import com.jmb.marvelapp.ui.common.loadUrl

class CharacterAdapter(private val listener: (Character) -> Unit) :
    ListAdapter<Character, BaseViewHolder<*>>(
        SerieDiffCallback
    ), Filterable {
    var mListRef: List<Character>? = null
    var listCharactersCopy: List<Character>? = null

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


    inner class SerieViewHolder(
        private val binding: ItemSerieBinding
    ) :
        BaseViewHolder<Character>(binding.root) {
        @SuppressLint("SetTextI18n")
        override fun bind(item: Character, position: Int) {
            binding.title.text = item.name
            val rute = "${item.thumbnail.path}/portrait_incredible.${item.thumbnail.extension}"
            binding.poster.loadUrl(rute)
            binding.root.setOnClickListener { listener(item) }
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint == null || constraint.isEmpty()) {
                    listCharactersCopy = mListRef
                    filterResults.count = listCharactersCopy!!.size
                    filterResults.values = listCharactersCopy
                } else {
                    val search = constraint.toString().lowercase()

                    val characterList = ArrayList<Character>()
                    for (item in listCharactersCopy!!) {
                        if (item.name.lowercase().contains(search)) {
                            characterList.add(item)
                        }
                    }
                    filterResults.count = characterList.size
                    filterResults.values = characterList
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mListRef = results!!.values as ArrayList<Character>
                submitList(mListRef)
            }

        }
    }


}