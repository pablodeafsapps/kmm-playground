package org.deafsapps.kmm.kmmplayground.character.data.datasource

import org.deafsapps.kmm.kmmplayground.base.Error
import org.deafsapps.kmm.kmmplayground.base.Result
import org.deafsapps.kmm.kmmplayground.character.data.api.CharactersService
import org.deafsapps.kmm.kmmplayground.character.data.model.CharactersDto

interface CharactersDataSource {

    interface Remote {

        suspend fun getAllCharacters(): Result<CharactersDto, Error>

        suspend fun getCharactersByPage(page: Int): Result<CharactersDto, Error>
    }
}

class RickAndMortyCharactersDataSource constructor(
    private val charactersService: CharactersService
) : CharactersDataSource.Remote {

    override suspend fun getAllCharacters(): Result<CharactersDto, Error> = getAllCharactersByPage()

    override suspend fun getCharactersByPage(page: Int): Result<CharactersDto, Error> =
        getAllCharactersByPage(page = page)

    private suspend fun getAllCharactersByPage(page: Int = 1): Result<CharactersDto, Error> =
        charactersService.getCharactersByPage(page = page)
}
