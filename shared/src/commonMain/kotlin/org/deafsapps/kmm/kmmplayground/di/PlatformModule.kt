package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.data.client.httpClient
import org.koin.dsl.module

val platformModule = module {
    single {
        httpClient {  }
    }
}
