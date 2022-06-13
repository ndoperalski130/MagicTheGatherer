package com.example.finalproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.databinding.FragmentSearchBinding
import com.example.finalproject.databinding.MagicListItemBinding
import com.example.finalproject.model.Card
import com.example.finalproject.model.CardObject
import com.example.finalproject.model.CardsResponse

class CardRecyclerViewAdapter(private val list: MutableList<CardObject> = mutableListOf())
    : RecyclerView.Adapter<CardRecyclerViewAdapter.CardViewHolder>()

{
    inner class CardViewHolder(private val binding: MagicListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(card: CardObject)
        {
            Glide.with(binding.ivMagicCardView)
                .load(card.imageUrl)
                .into(binding.ivMagicCardView)

            binding.tvCMC.text = card.cmc.toString()
            binding.tvCardName.text = card.name
        }
    }

    fun addNewCards(newCards: List<CardObject>)
    {
        list.clear()
        list.addAll(newCards)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardRecyclerViewAdapter.CardViewHolder = CardViewHolder(MagicListItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CardRecyclerViewAdapter.CardViewHolder, position: Int) {
        holder.onBind(list[position])
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
        TODO("Not yet implemented")
    }
}