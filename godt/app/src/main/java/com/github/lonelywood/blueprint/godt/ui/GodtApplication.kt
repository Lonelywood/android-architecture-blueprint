package com.github.lonelywood.blueprint.godt.ui

import android.app.Application
import com.github.lonelywood.blueprint.godt.BuildConfig
import com.github.lonelywood.blueprint.godt.ui.di.viewModelModule
import com.github.lonelywood.blueprint.godt.ui.log.CrashlyticsReportingTree
import com.github.lonelywood.blueprint.godt.ui.log.timberLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class GodtApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
        setupLogger()
    }

    private fun setupKoin() {
        startKoin {
            if (BuildConfig.DEBUG)
                timberLogger(Level.DEBUG)
            else
                timberLogger(Level.ERROR)

            androidContext(this@GodtApplication)
            modules(viewModelModule)
        }
    }

    private fun setupLogger() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        else
            Timber.plant(CrashlyticsReportingTree())
    }
}