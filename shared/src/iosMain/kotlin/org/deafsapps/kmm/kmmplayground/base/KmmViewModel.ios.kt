package org.deafsapps.kmm.kmmplayground.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual open class KmmViewModel {
    actual val scope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {
        scope.cancel()
    }
}
