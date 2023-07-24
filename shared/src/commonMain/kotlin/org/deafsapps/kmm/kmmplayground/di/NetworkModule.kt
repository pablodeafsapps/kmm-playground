package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.character.data.api.KtorCharactersService
import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.character.data.datasource.RickAndMortyCharactersDataSource
import org.koin.dsl.module

val networkModule = module {
    factory<CharactersDataSource.Remote> {
        RickAndMortyCharactersDataSource(
            charactersService = get()
        )
    }
    single {
        KtorCharactersService.create()
    }
}
