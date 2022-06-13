package com.example.finalproject.model

data class CardsResponse(
    val cards : List<CardObject>
)

data class CardObject(
    val name: String,
    val manaCost: String,
    val cmc: Double,
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
    val legalities: List<LegalityObject>,
    val id: String
)

data class LegalityObject(
    val format: String,
    val legality: String
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

data class Card(
    val cards: List<CardX>
)

data class CardX(
    val artist: String,
    val cmc: Double,
    val colorIdentity: List<String>,
    val colors: List<String>,
    val flavor: String,
    val foreignNames: List<ForeignName>,
    val id: String,
    val imageUrl: String,
    val layout: String,
    val legalities: List<Legality>,
    val manaCost: String,
    val multiverseid: String,
    val name: String,
    val number: String,
    val originalText: String,
    val originalType: String,
    val power: String,
    val printings: List<String>,
    val rarity: String,
    val rulings: List<Ruling>,
    val `set`: String,
    val setName: String,
    val subtypes: List<String>,
    val supertypes: List<String>,
    val text: String,
    val toughness: String,
    val type: String,
    val types: List<String>,
    val variations: List<String>
)

data class ForeignName(
    val flavor: String,
    val imageUrl: String,
    val language: String,
    val multiverseid: Int,
    val name: String,
    val text: String,
    val type: String
)

data class Legality(
    val format: String,
    val legality: String
)

data class Ruling(
    val date: String,
    val text: String
)
