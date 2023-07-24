package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.character.data.datasource.CharactersDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StartDiHelper : KoinComponent {
    val getCharactersDataSource: CharactersDataSource.Remote by inject()
}
