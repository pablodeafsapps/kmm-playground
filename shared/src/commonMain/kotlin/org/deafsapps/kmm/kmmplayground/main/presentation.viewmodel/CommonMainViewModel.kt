package org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel

import kotlinx.coroutines.CoroutineScope
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.domain.model.Character

expect abstract class CommonMainViewModel {
    val scope: CoroutineScope
    protected val charactersDataSource: CharactersDataSource.Remote

    suspend fun getCharacters(): List<Character>

    protected open fun onCleared()
}
