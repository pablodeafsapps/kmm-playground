package org.deafsapps.kmm.kmmplayground.android.main.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.data.model.CharacterDto
import org.deafsapps.kmm.kmmplayground.data.model.LocationDto
import org.deafsapps.kmm.kmmplayground.data.model.OriginDto
import org.deafsapps.kmm.kmmplayground.domain.model.Character
import org.deafsapps.kmm.kmmplayground.domain.model.Location
import org.deafsapps.kmm.kmmplayground.domain.model.Origin

class MainViewModel(
    private val charactersDataSource: CharactersDataSource.Remote,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

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
            charactersDataSource.getAllCharacters().onSuccess { characters ->
                    savedStateHandle["characters"] = characters?.results?.toBo() ?: emptyList()
                }.onFailure { th -> println(th.message) }
        }
    }
}

private fun List<CharacterDto>.toBo(): List<Character> = map { it.toBo() }

private fun CharacterDto.toBo(): Character = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin.toBo(),
    location = location.toBo(),
    image = image,
    episode = episode,
    url = url,
    created = created,
)

private fun OriginDto.toBo(): Origin = Origin(
    name = name, url = url
)

private fun LocationDto.toBo(): Location = Location(
    name = name, url = url
)
