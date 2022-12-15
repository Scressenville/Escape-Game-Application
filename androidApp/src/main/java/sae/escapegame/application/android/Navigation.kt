package sae.escapegame.application.android
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.Cinematic1Screen.route){
            Cinematic(painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy) ,stringArrayResource(id = R.array.cinematic1),
                Screen.Cinematic2Screen, navController)
        }
        composable(route = Screen.ChoixEnigme1.route){

        }
        composable(route = Screen.Cinematic2Screen.route){
            Cinematic(painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy) ,stringArrayResource(id = R.array.cinematic2),Screen.Cinematic3Screen, navController)
        }
        composable(route = Screen.Cinematic3Screen.route){
            Cinematic(painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy) ,stringArrayResource(id = R.array.cinematic3),Screen.MainScreen, navController)
        }


    }
}
