package org.deafsapps.kmm.kmmplayground.character.di

import org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel.CommonMainViewModel
import org.deafsapps.kmm.kmmplayground.character.presentation.viewmodel.MainViewModel
import org.koin.dsl.module

val characterModule = module {
    factory<CommonMainViewModel> {
        MainViewModel(charactersDataSource = get())
    }
}
