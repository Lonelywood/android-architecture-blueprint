package com.github.lonelywood.blueprint.godt.ui.di

import com.github.lonelywood.blueprint.godt.ui.recipes.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RecipesViewModel() }
}