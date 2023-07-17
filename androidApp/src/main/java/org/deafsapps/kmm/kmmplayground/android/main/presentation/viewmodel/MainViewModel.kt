package org.deafsapps.kmm.kmmplayground.android.main.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.domain.model.Character
import org.deafsapps.kmm.kmmplayground.domain.model.Characters

class MainViewModel(
    private val charactersDataSource: CharactersDataSource.Remote,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val characters: StateFlow<List<Character>> = savedStateHandle.getStateFlow("characters", emptyList())

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            savedStateHandle["characters"] = charactersDataSource.getAllCharacters()
        }
    }
}