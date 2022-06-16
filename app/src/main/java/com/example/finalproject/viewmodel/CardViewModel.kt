package com.example.finalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.CardsResponse
import com.example.finalproject.repository.CardsRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel(
    name: String?,
    rarity: String?,
    private val repoID: CardsRepositoryImpl) : ViewModel() {

    init {
        if (name != null && rarity != "Select rarity...") {
            getCardWithName(name, rarity)
        }
        else if (name != null && rarity == "Select rarity...")
        {
            getCardWithName(name, null)
        }
        else if(name.isNullOrEmpty() && rarity != "Select rarity...")
        {
            if (rarity != null) {
                getCardWithRarity(rarity)
            }
        }
    }

    private val _cards = MutableLiveData<CardsResponse>()

    val cards : LiveData<CardsResponse> get() = _cards

    private fun getCardWithName(name: String, rarity: String?)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoID.getCardWithName(name, rarity)
            _cards.postValue(response)
        }
    }

    private fun getCardWithRarity(rarity: String)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoID.getCardWithRarity(rarity)
            _cards.postValue(response)
        }
    }
}