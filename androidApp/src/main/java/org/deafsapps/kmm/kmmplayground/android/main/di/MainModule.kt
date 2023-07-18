package org.deafsapps.kmm.kmmplayground.android.main.di

import org.deafsapps.kmm.kmmplayground.android.main.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel(charactersDataSource = get(), savedStateHandle = get())
    }
}
