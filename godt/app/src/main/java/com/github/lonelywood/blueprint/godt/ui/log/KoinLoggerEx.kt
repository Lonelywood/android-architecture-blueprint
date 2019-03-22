package com.github.lonelywood.blueprint.godt.ui.log

import org.koin.core.KoinApplication
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

fun KoinApplication.timberLogger(
    level: Level = Level.INFO
): KoinApplication {
    KoinApplication.logger = TimberLogger(level)
    return this
}

class TimberLogger(lvl: Level = Level.INFO): Logger(lvl) {

    override fun log(level: Level, msg: MESSAGE) {
        if (this.level <= level) {
            LogOnLevel(msg)
        }
    }

    private fun LogOnLevel(msg: MESSAGE) {
        when (this.level) {
            Level.DEBUG -> Timber.d(msg)
            Level.INFO -> Timber.i(msg)
            Level.ERROR -> Timber.e(msg)
        }
    }
}