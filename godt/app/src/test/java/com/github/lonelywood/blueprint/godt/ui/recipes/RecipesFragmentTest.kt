package com.github.lonelywood.blueprint.godt.ui.recipes

import androidx.core.view.isVisible
import androidx.fragment.app.testing.launchFragmentInContainer
import com.github.lonelywood.blueprint.godt.R
import kotlinx.android.synthetic.main.recipes_fragment.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RecipesFragmentTest {
    @Test
    fun exampleTest() {
        val scenario = launchFragmentInContainer<RecipesFragment>(null, R.style.GodtTheme)

        scenario.onFragment {
            it.test.callOnClick()
            Assert.assertEquals(true, it.test.isVisible)
        }
    }
}