package org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.data.mapper.toBo
import org.deafsapps.kmm.kmmplayground.domain.model.Character

actual abstract class CommonMainViewModel(
    private val characsDataSource: CharactersDataSource.Remote
) : ViewModel() {

    actual val scope: CoroutineScope = viewModelScope
    protected actual val charactersDataSource: CharactersDataSource.Remote
        get() = characsDataSource

    actual suspend fun getCharacters(): List<Character> =
        charactersDataSource.getAllCharacters().getOrNull()?.results?.toBo() ?: emptyList()

    actual override fun onCleared() {
        super.onCleared()
    }
}

