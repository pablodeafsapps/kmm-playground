package org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel

import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character

expect abstract class CommonMainViewModel {
    protected val charactersDataSource: CharactersDataSource.Remote

    suspend fun getCharacters(): List<Character>
}
