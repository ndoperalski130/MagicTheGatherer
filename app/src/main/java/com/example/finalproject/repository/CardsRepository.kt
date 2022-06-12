package com.example.finalproject.repository

import com.example.finalproject.api.MagicAPI
import com.example.finalproject.model.CardsResponse

interface CardsRepository {

    suspend fun getCardWithName(name: String?) : CardsResponse
}

class CardsRepositoryImpl(private val service: MagicAPI = MagicAPI.getService()
) : CardsRepository
{
    override suspend fun getCardWithName(name: String?): CardsResponse
    {
        val response = service.getCardWithName(name = name)

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