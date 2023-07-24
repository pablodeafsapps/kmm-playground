package org.deafsapps.kmm.kmmplayground.base

import kotlinx.coroutines.CoroutineScope

expect open class KmmViewModel {
    val scope: CoroutineScope

    protected fun onCleared()
}
