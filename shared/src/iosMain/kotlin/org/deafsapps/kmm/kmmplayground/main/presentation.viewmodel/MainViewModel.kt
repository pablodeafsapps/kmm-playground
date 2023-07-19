package org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel

import org.deafsapps.kmm.kmmplayground.data.datasource.CharactersDataSource

class MainViewModel(
    charactersDataSource: CharactersDataSource.Remote,
) : CommonMainViewModel(characsDataSource = charactersDataSource)
