package com.github.lonelywood.blueprint.godt.ui.log

import android.util.Log
import timber.log.Timber

class CrashlyticsReportingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        // TODO: implement Firebase Crashlytics sending reports
    }
}