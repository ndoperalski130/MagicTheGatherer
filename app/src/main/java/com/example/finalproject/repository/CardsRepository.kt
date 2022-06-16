package com.example.finalproject.repository

import com.example.finalproject.api.MagicAPI
import com.example.finalproject.model.CardsResponse

interface CardsRepository {

    suspend fun getCardWithName(name: String, rarity: String?) : CardsResponse
    suspend fun getCardWithRarity(rarity: String) : CardsResponse
}

class CardsRepositoryImpl(private val service: MagicAPI = MagicAPI.getService()
) : CardsRepository
{
    override suspend fun getCardWithName(name: String, rarity: String?): CardsResponse
    {
        val response = service.getCardWithName(name = name, rarity = rarity)

        return if(response.isSuccessful)
        {
            response.body()!!
        }
        else
        {
            CardsResponse(emptyList())
        }

    }

    override suspend fun getCardWithRarity(rarity: String): CardsResponse {
        val response = service.getCardWithRarity(rarity = rarity)

        return if(response.isSuccessful)
        {
            response.body()!!
        }
        else
        {
            CardsResponse(emptyList())
        }
    }

}