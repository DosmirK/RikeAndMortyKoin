package com.example.rikeandmortykoin.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rikeandmortykoin.R
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.databinding.ItemCharacterBinding
import com.example.rikeandmortykoin.utils.loadImage

class CharactersPagingAdapter(
    var onClick:(position: Int) -> Unit

) : PagingDataAdapter<Character, CharactersPagingAdapter.CharacterViewHolder>(DIFF_UTIL_CALL_BACK) {

    private companion object {
        val DIFF_UTIL_CALL_BACK: DiffUtil.ItemCallback<Character> =
            object : DiffUtil.ItemCallback<Character>() {
                override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                    return oldItem.url == newItem.url
                }

                override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.bind(character)
            holder.itemView.setOnClickListener {
                onClick(character.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.apply {
                tvName.text = character.name
                tvStatus.text = character.status
                tvSpecies.text = character.species
                tvGender.text = character.gender
                ivCharacter.loadImage(character.image)

                val dot = when(character.status){
                    "Alive" -> R.drawable.ic_green_dot
                    "Dead" -> R.drawable.ic_red_dot
                    else -> R.drawable.ic_grey_dot
                }
                dotIndicator.setImageResource(dot)
            }
        }
    }
}