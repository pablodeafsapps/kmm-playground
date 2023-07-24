package org.deafsapps.kmm.kmmplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.deafsapps.kmm.kmmplayground.android.character.presentation.view.DetailScreen
import org.deafsapps.kmm.kmmplayground.android.character.presentation.view.MainScreen
import org.deafsapps.kmm.kmmplayground.android.character.presentation.viewmodel.MainViewModel
import org.deafsapps.kmm.kmmplayground.android.navigation.Detail
import org.deafsapps.kmm.kmmplayground.android.navigation.Main
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character
import org.koin.androidx.viewmodel.ext.android.getViewModel

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KmmApp(viewModel = getViewModel())
        }
    }
}

@Composable
private fun KmmApp(viewModel: MainViewModel) {
    KmmApplicationTheme {
        val navController: NavHostController = rememberNavController()
        val characters by viewModel.characters.collectAsStateWithLifecycle()
        Scaffold { innerPadding ->
            KmmAppNavHost(
                navController = navController,
                characterList = characters,
                onCharacterSelected = viewModel::onCharacterSelected,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
private fun KmmAppNavHost(
    navController: NavHostController,
    characterList: List<Character>,
    onCharacterSelected: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Main.route,
        modifier = modifier
    ) {
        composable(route = Main.route) {
            MainScreen(list = characterList, onCharacterSelected = onCharacterSelected)
        }
        composable(route = Detail.route) {
            DetailScreen()
        }
    }
}
