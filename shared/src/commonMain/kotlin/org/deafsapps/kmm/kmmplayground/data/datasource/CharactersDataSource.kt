package org.deafsapps.kmm.kmmplayground.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import org.deafsapps.kmm.kmmplayground.data.api.HttpRoutes
import org.deafsapps.kmm.kmmplayground.data.model.CharactersDto


interface CharactersDataSource {

    interface Remote {

        suspend fun getAllCharacters(): Result<CharactersDto?>

        suspend fun getCharactersByPage(page: Int): Result<CharactersDto?>
    }
}

class RickAndMortyCharactersDataSource constructor(
    private val client: HttpClient
) : CharactersDataSource.Remote {

    override suspend fun getAllCharacters(): Result<CharactersDto?> =
        getAllCharactersByPage()

    override suspend fun getCharactersByPage(page: Int): Result<CharactersDto?> =
        getAllCharactersByPage(page = page)

    private suspend fun getAllCharactersByPage(page: Int = 1): Result<CharactersDto?> =
        client.get {
            url(HttpRoutes.CHARACTER)
            parameter("page", page)
        }.runCatching {
            Json.decodeFromString<CharactersDto>(bodyAsText())
        }
}
