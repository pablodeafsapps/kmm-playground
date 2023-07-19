package org.deafsapps.kmm.kmmplayground.main.di

import org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel.MainViewModel
import org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel.CommonMainViewModel
import org.koin.dsl.module

val mainModule = module {
    factory<CommonMainViewModel> {
        MainViewModel(charactersDataSource = get())
    }
}
