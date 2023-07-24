package org.deafsapps.kmm.kmmplayground.android.character.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.character.data.mapper.toBo
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character
import org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel.CommonMainViewModel

class MainViewModel(
    charactersDataSource: CharactersDataSource.Remote,
    private val savedStateHandle: SavedStateHandle
) : CommonMainViewModel(characsDataSource = charactersDataSource) {

    val characters: StateFlow<List<Character>> =
        savedStateHandle.getStateFlow("characters", emptyList())

    init {
        loadCharacters()
    }

    fun onCharacterSelected(character: Character) {
        println("Character ${character.name} selected")
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            charactersDataSource.getAllCharacters()
                .onSuccess { characters ->
                    savedStateHandle["characters"] = characters?.results?.toBo() ?: emptyList()
                }.onFailure { th -> println(th.message) }
        }
    }
}
