package org.deafsapps.kmm.kmmplayground.character.data.datasource

import org.deafsapps.kmm.kmmplayground.character.data.api.CharactersService
import org.deafsapps.kmm.kmmplayground.character.data.model.CharactersDto

interface CharactersDataSource {

    interface Remote {

        suspend fun getAllCharacters(): Result<CharactersDto?>

        suspend fun getCharactersByPage(page: Int): Result<CharactersDto?>
    }
}

class RickAndMortyCharactersDataSource constructor(
    private val charactersService: CharactersService
) : CharactersDataSource.Remote {

    override suspend fun getAllCharacters(): Result<CharactersDto?> =
        getAllCharactersByPage()

    override suspend fun getCharactersByPage(page: Int): Result<CharactersDto?> =
        getAllCharactersByPage(page = page)

    private suspend fun getAllCharactersByPage(page: Int = 1): Result<CharactersDto?> =
        runCatching {
            charactersService.getCharactersByPage(page = page)
        }
}
