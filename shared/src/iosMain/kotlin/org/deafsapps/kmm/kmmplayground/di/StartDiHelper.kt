package org.deafsapps.kmm.kmmplayground.di

import org.deafsapps.kmm.kmmplayground.domain.model.Character
import org.deafsapps.kmm.kmmplayground.main.presentation.viewmodel.CommonMainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.cancellation.CancellationException

class StartDiHelper : KoinComponent {
    private val viewModel : CommonMainViewModel by inject()
    @Throws(CancellationException::class)
    suspend fun getCharacters(): List<Character> = viewModel.getCharacters()
}
