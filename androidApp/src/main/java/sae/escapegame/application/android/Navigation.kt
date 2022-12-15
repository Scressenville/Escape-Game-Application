package sae.escapegame.application.android
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route){
            Cinematic1Screen(navController = navController)
        }
        composable(route = Screen.EnigmeOneScreen.route){
            enigmeOne(navController = navController)
        }
        composable(route = Screen.ResolvEnigmeOneScreen.route){
            resolvEnigmeOne()
        }
    }
}

