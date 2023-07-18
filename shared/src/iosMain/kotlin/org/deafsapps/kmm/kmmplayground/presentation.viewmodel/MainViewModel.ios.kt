package org.deafsapps.kmm.kmmplayground.presentation.viewmodel

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual abstract class CommonMainViewModel {

    actual val scope = MainScope()

    protected actual open fun onCleared() {}

    fun clear() {
        onCleared()
        scope.cancel()
    }
}
