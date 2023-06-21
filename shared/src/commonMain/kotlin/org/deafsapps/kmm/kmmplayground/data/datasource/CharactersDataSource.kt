package org.deafsapps.kmm.kmmplayground.data.datasource

import org.deafsapps.kmm.kmmplayground.data.model.CharactersDto


interface CharactersDataSource {

    interface Remote {

        suspend fun getAllCharacters(): Result<CharactersDto?>

        suspend fun getCharactersByPage(page: Int): Result<CharactersDto?>
    }
}

class RickAndMortyCharactersDataSource constructor(
) : CharactersDataSource.Remote {

    override suspend fun getAllCharacters(): Result<CharactersDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersByPage(page: Int): Result<CharactersDto?> {
        TODO("Not yet implemented")
    }
}
