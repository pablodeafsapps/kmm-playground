package org.deafsapps.kmm.kmmplayground.android

import android.app.Application
import org.deafsapps.kmm.kmmplayground.android.di.androidModule
import org.deafsapps.kmm.kmmplayground.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KmmPlaygroundApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KmmPlaygroundApplication)
            androidLogger()
            modules(commonModule() + androidModule())
        }
    }
}
