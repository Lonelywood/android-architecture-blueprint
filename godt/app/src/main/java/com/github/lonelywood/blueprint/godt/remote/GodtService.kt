package com.github.lonelywood.blueprint.godt.remote

import com.github.lonelywood.blueprint.godt.remote.model.PopularRecipesDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.RecipeDetailsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GodtService {
    @GET("popular/recipes")
    fun getPopularRecipes(@Query("limit") limit: Int = 20): Single<List<PopularRecipesDataResponse>>

    @GET("recipes/{id}")
    fun getRecipeDetails(@Path("id") recipeId: Int): Single<RecipeDetailsResponse>
}