package org.deafsapps.kmm.kmmplayground.presentation.viewmodel

import kotlinx.coroutines.CoroutineScope

expect abstract class CommonMainViewModel() {
    val scope: CoroutineScope
    protected open fun onCleared()
}
