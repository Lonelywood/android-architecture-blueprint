package com.github.lonelywood.blueprint.godt.ui.recipes

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.lonelywood.blueprint.godt.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipesFragmentInstrumentedTest {

    @Test
    fun exampleTest() {
        val scenario = launchFragmentInContainer<RecipesFragment>(null, R.style.GodtTheme)

        onView(withId(R.id.test)).perform(click())
        onView(withId(R.id.test)).check(matches(isDisplayed()))
    }
}