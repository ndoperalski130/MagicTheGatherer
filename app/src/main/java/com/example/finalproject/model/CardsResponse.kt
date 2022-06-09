package com.example.finalproject.model

data class CardsResponse(
    val cards : List<CardObject>
)

data class CardObject(
    val name: String,
    val manaCost: String,
    val cmc: Int,
    val colors: List<String>,
    val colorIdentity: List<String>,
    val type: String,
    val types: List<String>,
    val subtypes: List<String>,
    val rarity: String,
    val set: String,
    val setName: String,
    val text: String,
    val artist: String,
    val number: String,
    val power: String?,             // instant
    val toughness: String?,         // sorcery have no PT
    val layout: String,
    val multiverseid: String,
    val imageUrl: String,
    val variations: List<String>,
    val foreignNames: List<ForeignCardObject>,
    val printings: List<String>,
    val originalText: String,
    val originalType: String,
    val legalities: List<String>,
    val id: String
)

data class ForeignCardObject(
    val name: String,
    val text: String,
    val type: String,
    val flavor: String,
    val imageUrl: String,
    val language: String,
    val multiverseid: String
)
