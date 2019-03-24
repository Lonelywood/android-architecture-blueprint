package com.github.lonelywood.blueprint.godt.remote.mapper

import com.github.lonelywood.blueprint.godt.data.model.Recipe
import com.github.lonelywood.blueprint.godt.remote.model.PopularRecipesDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.RecipeDetailsResponse

interface RemoteRecipeMapper {
    fun mapFromRemote(type: PopularRecipesDataResponse): Recipe
    fun mapFromRemote(type: RecipeDetailsResponse, image: String) : Recipe
}