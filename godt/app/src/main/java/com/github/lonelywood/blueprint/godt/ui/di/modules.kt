package com.github.lonelywood.blueprint.godt.ui.di

import com.github.lonelywood.blueprint.godt.BuildConfig
import com.github.lonelywood.blueprint.godt.remote.GodtServiceFactory
import com.github.lonelywood.blueprint.godt.remote.IRemoteRecipesService
import com.github.lonelywood.blueprint.godt.remote.RemoteRecipesService
import com.github.lonelywood.blueprint.godt.remote.mapper.RecipeMapper
import com.github.lonelywood.blueprint.godt.remote.mapper.RemoteRecipeMapper
import com.github.lonelywood.blueprint.godt.ui.recipes.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RecipesViewModel() }
}

val remoteModel = module {
    single { GodtServiceFactory.makeGodtService(BuildConfig.DEBUG) }
    single { RecipeMapper() as RemoteRecipeMapper }
    single { RemoteRecipesService(get(), get()) as IRemoteRecipesService }
}