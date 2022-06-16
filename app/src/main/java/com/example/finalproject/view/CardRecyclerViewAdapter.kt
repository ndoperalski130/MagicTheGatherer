package com.example.finalproject.view

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.drawToBitmap
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentSearchBinding
import com.example.finalproject.databinding.MagicListItemBinding
import com.example.finalproject.model.Card
import com.example.finalproject.model.CardObject
import com.example.finalproject.model.CardsResponse

class CardRecyclerViewAdapter(private val list: MutableList<CardObject> = mutableListOf(),
                                private val openCardDetails: (CardObject) -> Unit)
    : RecyclerView.Adapter<CardRecyclerViewAdapter.CardViewHolder>()

{
    inner class CardViewHolder(private val binding: MagicListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(card: CardObject)
        {
            // note
            // Glide does NOT work with webpages

            //val jaceUrl = card.imageUrl
            //jaceUrl.replace("http", "https")
            //println(jaceUrl)
            /*Glide.with(binding.ivMagicCardView)
                .load(jaceUrl)
                .error(android.R.drawable.stat_notify_error)
                .into(binding.ivMagicCardView)*/

            // this next stuff sucks
            // implement better webviews google >:(

            // if our imageurl isn't blank or null, there's an image for the card
            if(!card.imageUrl.isNullOrBlank())
            {
                binding.wvTestWebView.loadUrl(card.imageUrl)

                binding.wvTestWebView.settings.javaScriptEnabled = false
                binding.wvTestWebView.settings.loadWithOverviewMode = true
                binding.wvTestWebView.settings.useWideViewPort = true

                binding.pbLoading.visibility = View.GONE

                binding.wvTestWebView.webViewClient = WebViewClient()
            }


            //println(card.cmc)
            //binding.tvCMC.text = card.cmc.toString()

            // assign the data to the views :D
            binding.tvManaCost.text = card.manaCost
            binding.tvCardName.text = card.name
            binding.tvRulesText.text = card.text

            // open more details about the card
            binding.root.setOnClickListener {
                openCardDetails(card)
            }
        }
    }

    // add all our new cards to the empty list
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
        LayoutInflater.from(parent.context),
        parent,
        false))

    // call the viewHolder onBind here
    override fun onBindViewHolder(holder: CardRecyclerViewAdapter.CardViewHolder, position: Int) {
        holder.onBind(list[position])

    }

    // get the size of our list
    override fun getItemCount(): Int {
        return list.size

    }
}