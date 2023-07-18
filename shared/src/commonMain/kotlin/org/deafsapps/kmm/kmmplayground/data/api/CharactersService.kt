package org.deafsapps.kmm.kmmplayground.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.deafsapps.kmm.kmmplayground.data.client.httpClient
import org.deafsapps.kmm.kmmplayground.data.model.CharacterDto
import org.deafsapps.kmm.kmmplayground.data.model.CharactersDto

interface CharactersService {

    suspend fun gerCharacters(): CharactersDto

    suspend fun gerCharactersById(id: Int): CharacterDto?

    suspend fun gerCharactersByName(name: String): CharacterDto?
}

class KtorCharactersService(
    private val client: HttpClient
) : CharactersService {

    override suspend fun gerCharacters(): CharactersDto =
        try {
            client.get {
                url(HttpRoutes.CHARACTERS)
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
            CharactersDto(results = emptyList())
        }

    override suspend fun gerCharactersById(id: Int): CharacterDto? {
        TODO("Not yet implemented")
    }

    override suspend fun gerCharactersByName(name: String): CharacterDto? {
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
