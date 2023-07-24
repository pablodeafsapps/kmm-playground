package org.deafsapps.kmm.kmmplayground.android.character.di

import org.deafsapps.kmm.kmmplayground.android.character.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    viewModel {
        MainViewModel(charactersDataSource = get(), savedStateHandle = get())
    }
}
