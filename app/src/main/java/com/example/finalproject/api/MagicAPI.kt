package com.example.finalproject.api

import com.example.finalproject.model.CardsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MagicAPI {

    /*
    http://api.magicthegathering.io/v1/cards
     */

    @GET("cards")
    suspend fun getCardWithName(
        @Query(NAME) name: String?
    ) : Response<CardsResponse>

    @GET("cards")
    suspend fun getCardWithRarity(
        @Query(RARITY) rarity: String?
    ) : Response<CardsResponse>

    companion object
    {
        const val BASEURL = "http://api.magicthegathering.io/v1/"
        private var instance : MagicAPI? = null

        fun getService() : MagicAPI
        {
            if(instance == null)
            {
                instance = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MagicAPI::class.java)
            }
            return instance!!
        }

        const val NAME = "name"
        const val RARITY = "rarity"
        const val CMC = 0.0
    }

}