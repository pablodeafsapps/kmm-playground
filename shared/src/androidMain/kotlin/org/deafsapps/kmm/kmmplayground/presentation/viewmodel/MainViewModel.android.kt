package org.deafsapps.kmm.kmmplayground.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class CommonMainViewModel actual constructor() : ViewModel() {

    actual val scope: CoroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}
