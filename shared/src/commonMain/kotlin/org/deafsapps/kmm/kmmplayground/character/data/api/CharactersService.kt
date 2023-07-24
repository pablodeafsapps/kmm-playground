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
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.deafsapps.kmm.kmmplayground.base.Err
import org.deafsapps.kmm.kmmplayground.base.Error
import org.deafsapps.kmm.kmmplayground.base.Ok
import org.deafsapps.kmm.kmmplayground.base.RedirectError
import org.deafsapps.kmm.kmmplayground.base.RequestError
import org.deafsapps.kmm.kmmplayground.base.Result
import org.deafsapps.kmm.kmmplayground.base.ServerError
import org.deafsapps.kmm.kmmplayground.base.UnknownError
import org.deafsapps.kmm.kmmplayground.character.data.model.CharacterDto
import org.deafsapps.kmm.kmmplayground.character.data.model.CharactersDto
import org.deafsapps.kmm.kmmplayground.data.client.httpClient

interface CharactersService {

    suspend fun getCharacters(): Result<CharactersDto, Error>

    suspend fun getCharactersByPage(page: Int): Result<CharactersDto, Error>

    suspend fun getCharactersById(id: Int): CharacterDto?

    suspend fun getCharactersByName(name: String): CharacterDto?
}

class KtorCharactersService(
    private val client: HttpClient
) : CharactersService {

    override suspend fun getCharacters(): Result<CharactersDto, Error> =
        getCharactersByPage(page = 1)

    override suspend fun getCharactersByPage(page: Int): Result<CharactersDto, Error> = try {
        Ok(
            value = client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = HttpRoutes.BASE_URL
                    path(HttpRoutes.CHARACTER_PATH)
                    parameters.append("page", page.toString())
                }
            }.body()
        )
    } catch (e: RedirectResponseException) {
        // 3xx - responses
        println("Error:  ${e.response.status.description}")
        Err(error = RedirectError(msg = e.response.status.description, ex = e))
    } catch (e: ClientRequestException) {
        // 4xx - responses
        println("Error:  ${e.response.status.description}")
        Err(error = RequestError(msg = e.response.status.description, ex = e))
    } catch (e: ServerResponseException) {
        // 5xx - responses
        println("Error:  ${e.response.status.description}")
        Err(error = ServerError(msg = e.response.status.description, ex = e))
    } catch (e: Exception) {
        // unknown
        println("Error:  ${e.message}")
        Err(error = UnknownError(msg = e.message.toString(), ex = e))
    }

    override suspend fun getCharactersById(id: Int): CharacterDto? {
        TODO("Not yet implemented")
    }

    override suspend fun getCharactersByName(name: String): CharacterDto? {
        TODO("Not yet implemented")
    }

    companion object {
        fun create(): CharactersService = KtorCharactersService(client = httpClient {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        })
    }
}
