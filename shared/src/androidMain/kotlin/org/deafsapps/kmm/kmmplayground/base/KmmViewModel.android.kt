package org.deafsapps.kmm.kmmplayground.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class KmmViewModel : ViewModel() {
    actual val scope: CoroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}
