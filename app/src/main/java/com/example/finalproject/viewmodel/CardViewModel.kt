package com.example.finalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.Card
import com.example.finalproject.model.CardsResponse
import com.example.finalproject.repository.CardsRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel(private val repoID: CardsRepositoryImpl) : ViewModel() {

    private val _cards = MutableLiveData<CardsResponse>()

    val cards : LiveData<CardsResponse> get() = _cards

    private fun getCardWithName(name: String)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoID.getCardWithName(name)
            _cards.postValue(response)
        }
    }
}