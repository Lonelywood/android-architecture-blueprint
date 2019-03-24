package com.github.lonelywood.blueprint.godt.remote

import com.github.lonelywood.blueprint.godt.data.model.Recipe
import com.github.lonelywood.blueprint.godt.remote.mapper.RecipeMapper
import com.github.lonelywood.blueprint.godt.remote.mapper.RemoteRecipeMapper
import io.mockk.MockKAnnotations
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class RemoteRecipesServiceTest {
    @MockK private lateinit var godtService: GodtService

    private lateinit var mapper: RemoteRecipeMapper
    private lateinit var remoteRecipesService: IRemoteRecipesService

    init {
        MockKAnnotations.init(this, relaxed = true)
    }

    @Before
    fun setup() {
        clearMocks(godtService)

        mapper = RecipeMapper()
        remoteRecipesService = RemoteRecipesService(godtService, mapper)
    }

    @Test
    fun getPopularRecipesCompletes() {
        every { godtService.getPopularRecipes() } returns Single.just(mutableListOf(RemoteResponseFactory.getRandomPopularRecipe()))

        remoteRecipesService.getPopularRecipes()
            .test()
            .assertComplete()
    }

    @Test
    fun getPopularRecipesReturnsData() {
        val recipes = mutableListOf(
            RemoteResponseFactory.getRandomPopularRecipe(),
            RemoteResponseFactory.getRandomPopularRecipe(),
            RemoteResponseFactory.getRandomPopularRecipe()
        )

        every { godtService.getPopularRecipes() } returns Single.just(recipes)

        val expected = mutableListOf<Recipe>()
        recipes.forEach {
            expected.add(mapper.mapFromRemote(it))
        }

        remoteRecipesService.getPopularRecipes()
            .test()
            .assertValue(expected)
    }

    @Test
    fun getRecipeDetailsCompletes() {
        val recipe = mapper.mapFromRemote(RemoteResponseFactory.getRandomPopularRecipe())

        every { godtService.getRecipeDetails(any()) } returns Single.just(RemoteResponseFactory.getRandomRecipeDetails())

        remoteRecipesService.getRecipeDetails(recipe)
            .test()
            .assertComplete()
    }

    @Test
    fun getRecipeDetailsReturnsData() {
        val recipe = mapper.mapFromRemote(RemoteResponseFactory.getRandomPopularRecipe())
        val details = RemoteResponseFactory.getRandomRecipeDetails()

        every { godtService.getRecipeDetails(any()) } returns Single.just(details)

        remoteRecipesService.getRecipeDetails(recipe)
            .test()
            .assertValue(mapper.mapFromRemote(details, recipe.image))
    }
}