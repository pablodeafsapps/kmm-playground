package org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel

import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource

class MainViewModel(
    charactersDataSource: CharactersDataSource.Remote,
) : CommonMainViewModel(characsDataSource = charactersDataSource)
