package org.deafsapps.kmm.kmmplayground.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(commonModule() + iosModule())
    }
}
