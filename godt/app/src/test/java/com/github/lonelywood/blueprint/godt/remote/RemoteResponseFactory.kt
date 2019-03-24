package com.github.lonelywood.blueprint.godt.remote

import com.github.lonelywood.blueprint.godt.remote.model.IngredientsDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.IngredientsElementsResponse
import com.github.lonelywood.blueprint.godt.remote.model.PopularRecipesDataResponse
import com.github.lonelywood.blueprint.godt.remote.model.RecipeDetailsResponse
import java.util.concurrent.ThreadLocalRandom

class RemoteResponseFactory {
    companion object {
        fun randomInt(): Int
                = ThreadLocalRandom.current().nextInt(0, 10000 + 1)

        fun randomFloat(): Float
                = ThreadLocalRandom.current().nextInt(0, 10000 + 1) / 100f

        fun randomString(): String
                = java.util.UUID.randomUUID().toString()

        fun getRandomPopularRecipe(): PopularRecipesDataResponse
                = PopularRecipesDataResponse(randomInt(), randomString(), randomInt(), randomString())

        fun getRandomRecipeDetails(): RecipeDetailsResponse {
            return RecipeDetailsResponse(randomInt(), randomString(), randomString(), randomInt(),
                mutableListOf(
                    IngredientsDataResponse(
                        null, null, mutableListOf(
                            IngredientsElementsResponse(
                                randomInt(),
                                randomFloat(),
                                randomString(),
                                randomString(),
                                randomString(),
                                randomString()

                            ),
                            IngredientsElementsResponse(
                                randomInt(),
                                null,
                                null,
                                randomString(),
                                randomString(),
                                randomString()
                            )
                        )
                    ),
                    IngredientsDataResponse(
                        null, null, mutableListOf()
                    )
                )
            )
        }
    }
}