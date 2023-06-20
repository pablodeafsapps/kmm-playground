package org.deafsapps.kmm.kmmplayground.data.datasource

import org.deafsapps.kmm.kmmplayground.data.model.CharactersDto


interface CharactersDataSource {

    interface Remote {

        suspend fun getAllCharactersListResponse(): Result<CharactersDto?>

        suspend fun getCharactersNextPage(page: Int): Result<CharactersDto?>
    }
}

class RickAndMortyCharacterDataSource constructor(
) : CharactersDataSource.Remote {

    override suspend fun getAllCharactersListResponse(): Result<CharactersDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersNextPage(page: Int): Result<CharactersDto?> {
        TODO("Not yet implemented")
    }
}
