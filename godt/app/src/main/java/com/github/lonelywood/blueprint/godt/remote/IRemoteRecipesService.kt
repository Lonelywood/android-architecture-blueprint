package com.github.lonelywood.blueprint.godt.remote

import com.github.lonelywood.blueprint.godt.data.model.Recipe
import io.reactivex.Single

interface IRemoteRecipesService {
    fun getPopularRecipes(): Single<List<Recipe>>
    fun getRecipeDetails(recipe: Recipe): Single<Recipe>
}