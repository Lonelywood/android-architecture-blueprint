package com.github.lonelywood.blueprint.godt.data.model

data class Recipe(
    val id: Int,
    val title: String,
    val preparationTime: Int,
    val image: String,
    val description: String = "",
    val ingredients: List<List<Ingredient>>? = null
)