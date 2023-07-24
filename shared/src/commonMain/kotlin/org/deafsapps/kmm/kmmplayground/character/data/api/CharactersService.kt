package org.deafsapps.kmm.kmmplayground.character.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.host
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.deafsapps.kmm.kmmplayground.data.client.httpClient
import org.deafsapps.kmm.kmmplayground.character.data.model.CharacterDto
import org.deafsapps.kmm.kmmplayground.character.data.model.CharactersDto

interface CharactersService {

    suspend fun getCharacters(): CharactersDto

    suspend fun getCharactersByPage(page: Int): CharactersDto

    suspend fun getCharactersById(id: Int): CharacterDto?

    suspend fun getCharactersByName(name: String): CharacterDto?
}

class KtorCharactersService(
    private val client: HttpClient
) : CharactersService {

    override suspend fun getCharacters(): CharactersDto =
        getCharactersByPage(page = 1)

    override suspend fun getCharactersByPage(page: Int): CharactersDto =
        try {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = HttpRoutes.BASE_URL
                    path(HttpRoutes.CHARACTER_PATH)
                    parameters.append("page", page.toString())
                }
            }.body()
        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error:  ${e.response.status.description}")
            CharactersDto()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error:  ${e.response.status.description}")
            CharactersDto()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error:  ${e.response.status.description}")
            CharactersDto()
        } catch (e: Exception) {
            // unknown
            println("Error:  ${e.message}")
            CharactersDto()
        }

    override suspend fun getCharactersById(id: Int): CharacterDto? {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersByName(name: String): CharacterDto? {
        TODO("Not yet implemented")
    }

    companion object {
        fun create(): CharactersService = KtorCharactersService(
            client = httpClient {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }
        )
    }
}
