package org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel

import org.deafsapps.kmm.kmmplayground.base.Error
import org.deafsapps.kmm.kmmplayground.base.Result
import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character

expect abstract class CommonMainViewModel {
    protected val charactersDataSource: CharactersDataSource.Remote

    suspend fun getCharacters(): Result<List<Character>, Error>
}
