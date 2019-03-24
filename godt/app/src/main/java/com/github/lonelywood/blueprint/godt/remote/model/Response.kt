package com.github.lonelywood.blueprint.godt.remote.model

data class PopularRecipesDataResponse(
    val id: Int,
    val title: String,
    val preparationTime: Int,
    val image: String
)

data class RecipeDetailsResponse(
    val id: Int,
    val title: String,
    val description: String,
    val preparationTime: Int,
    val ingredients: List<IngredientsDataResponse>
)

data class IngredientsDataResponse(
    val id: Int?,
    val name: String?,
    val elements: List<IngredientsElementsResponse>
)

data class IngredientsElementsResponse(
    val id: Int,
    val amount: Float?,
    val hint: String?,
    val name: String,
    val unitName: String,
    val symbol: String
)