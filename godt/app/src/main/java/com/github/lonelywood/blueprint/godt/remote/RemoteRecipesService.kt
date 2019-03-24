package com.github.lonelywood.blueprint.godt.remote

import com.github.lonelywood.blueprint.godt.data.model.Recipe
import com.github.lonelywood.blueprint.godt.remote.mapper.RemoteRecipeMapper
import io.reactivex.Single

class RemoteRecipesService(
    private val godtService: GodtService,
    private val mapper: RemoteRecipeMapper
): IRemoteRecipesService {

    override fun getPopularRecipes(): Single<List<Recipe>> {
        return godtService.getPopularRecipes()
            .map {
                val recipes = mutableListOf<Recipe>()
                it.forEach { recipes.add(mapper.mapFromRemote(it)) }
                recipes
            }
    }

    override fun getRecipeDetails(recipe: Recipe): Single<Recipe> {
        return godtService.getRecipeDetails(recipe.id)
            .map {
                mapper.mapFromRemote(it, recipe.image)
            }
    }
}