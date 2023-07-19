package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.data.client.httpClient
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.data.datasource.RickAndMortyCharactersDataSource
import org.koin.dsl.module

val networkModule = module {
    factory<CharactersDataSource.Remote> {
        RickAndMortyCharactersDataSource(
            client = get()
        )
    }
    single {
        httpClient {  }
    }
}
