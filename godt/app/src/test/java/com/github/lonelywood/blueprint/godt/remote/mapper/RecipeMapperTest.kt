package com.github.lonelywood.blueprint.godt.remote.mapper

import com.github.lonelywood.blueprint.godt.remote.RemoteResponseFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RecipeMapperTest {
    private lateinit var mapper: RemoteRecipeMapper

    @Before
    fun setUp() {
        mapper = RecipeMapper()
    }

    @Test
    fun `mapped recipe from popular recipes response contains correct values`() {
        val popularRecipe = RemoteResponseFactory.getRandomPopularRecipe()
        val recipe = mapper.mapFromRemote(popularRecipe)

        assertEquals(popularRecipe.id, recipe.id)
        assertEquals(popularRecipe.title, recipe.title)
        assertEquals(popularRecipe.preparationTime, recipe.preparationTime)
        assertEquals(popularRecipe.image, recipe.image)
        assertEquals("", recipe.description)
        assertEquals(null, recipe.ingredients)
    }

    @Test
    fun `mapped recipe from detailed response contains correct values`() {
        val image = RemoteResponseFactory.randomString()
        val detailedRecipe = RemoteResponseFactory.getRandomRecipeDetails()
        val recipe = mapper.mapFromRemote(detailedRecipe, image)

        assertEquals(detailedRecipe.id, recipe.id)
        assertEquals(detailedRecipe.title, recipe.title)
        assertEquals(detailedRecipe.preparationTime, recipe.preparationTime)
        assertEquals(image, recipe.image)
        assertEquals(detailedRecipe.description, recipe.description)

        assertEquals(detailedRecipe.ingredients.count(), recipe.ingredients?.count())
        assertEquals(detailedRecipe.ingredients[0].elements[0].id, recipe.ingredients!![0][0].id)
        assertEquals(detailedRecipe.ingredients[0].elements[0].amount, recipe.ingredients!![0][0].amount)
        assertEquals(detailedRecipe.ingredients[0].elements[0].hint, recipe.ingredients!![0][0].hint)
        assertEquals(detailedRecipe.ingredients[0].elements[0].name, recipe.ingredients!![0][0].name)
        assertEquals(detailedRecipe.ingredients[0].elements[0].unitName, recipe.ingredients!![0][0].unitName)
        assertEquals(detailedRecipe.ingredients[0].elements[0].symbol, recipe.ingredients!![0][0].symbol)

        assertEquals(detailedRecipe.ingredients[0].elements[1].amount, recipe.ingredients!![0][1].amount)
        assertEquals(detailedRecipe.ingredients[0].elements[1].hint, recipe.ingredients!![0][1].hint)

        assertEquals(detailedRecipe.ingredients[1].elements.count(), recipe.ingredients!![1].count())
    }
}