package com.github.lonelywood.blueprint.godt.remote.mapper

import com.github.lonelywood.blueprint.godt.data.model.Ingredient
import com.github.lonelywood.blueprint.godt.data.model.Recipe
import com.github.lonelywood.blueprint.godt.remote.model.IngredientsDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.IngredientsElementsResponse
import com.github.lonelywood.blueprint.godt.remote.model.PopularRecipesDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.RecipeDetailsResponse

class RecipeMapper: RemoteRecipeMapper {

    override fun mapFromRemote(type: PopularRecipesDataResponse): Recipe {
        return Recipe(type.id, type.title, type.preparationTime, type.image)
    }

    override fun mapFromRemote(type: RecipeDetailsResponse, image: String) : Recipe {
        return Recipe(type.id, type.title, type.preparationTime, image, type.description, mapIgredients(type.ingredients))
    }

    private fun mapIgredients(type: List<IngredientsDataResponse>): List<List<Ingredient>>? {
        val ingredients = mutableListOf<List<Ingredient>>()

        type.forEach {
            val list = mutableListOf<Ingredient>()

            it.elements.forEach { element: IngredientsElementsResponse ->
                list.add(Ingredient(element.id, element.amount, element.hint, element.name, element.unitName, element.symbol))
            }

            ingredients.add(list)
        }

        return ingredients
    }
}