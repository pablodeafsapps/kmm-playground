package org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.data.mapper.toBo
import org.deafsapps.kmm.kmmplayground.domain.model.Character

actual abstract class CommonMainViewModel(
    private val characsDataSource: CharactersDataSource.Remote
) {

    actual val scope = MainScope()
    protected actual val charactersDataSource: CharactersDataSource.Remote
        get() = characsDataSource

    actual suspend fun getCharacters(): List<Character> =
        charactersDataSource.getAllCharacters().getOrNull()?.results?.toBo() ?: emptyList()

    protected actual open fun onCleared() {}

    fun clear() {
        onCleared()
        scope.cancel()
    }
}
