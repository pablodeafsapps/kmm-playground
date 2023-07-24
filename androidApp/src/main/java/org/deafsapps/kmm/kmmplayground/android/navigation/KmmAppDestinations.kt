package org.deafsapps.kmm.kmmplayground.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class KmmAppDestination(val icon: ImageVector, val route: String)

/**
 * KMM App navigation destinations
 */
object Main : KmmAppDestination(icon = Icons.Filled.Home, route = "main")

object Detail : KmmAppDestination(icon = Icons.Filled.Add, route = "detail")
