package org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel

import org.deafsapps.kmm.kmmplayground.base.KmmViewModel
import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.deafsapps.kmm.kmmplayground.character.data.mapper.toBo
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character

actual abstract class CommonMainViewModel(
    private val characsDataSource: CharactersDataSource.Remote
) : KmmViewModel() {

    protected actual val charactersDataSource: CharactersDataSource.Remote
        get() = characsDataSource

    actual suspend fun getCharacters(): List<Character> =
        charactersDataSource.getAllCharacters().getOrNull()?.results?.toBo() ?: emptyList()
}
