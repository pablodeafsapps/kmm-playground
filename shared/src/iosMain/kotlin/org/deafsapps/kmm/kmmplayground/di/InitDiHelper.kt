package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.main.di.mainModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule() + mainModule)
    }
}
