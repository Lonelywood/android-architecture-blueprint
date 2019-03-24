package com.github.lonelywood.blueprint.godt.data.model

data class Ingredient(
    val id: Int,
    val amount: Float?,
    val hint: String?,
    val name: String,
    val unitName: String,
    val symbol: String
)