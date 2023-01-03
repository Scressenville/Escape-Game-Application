package sae.escapegame.application.android
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import sae.escapegame.application.android.QCM.skillTest

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screen.Cinematic1Screen.route) {
            Cinematic(
                painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic1),
                Screen.ChoixEnigme1,
                navController
            )
        }

        composable(route = Screen.DetailScreen.route) {
            Cinematic1Screen(navController = navController)
        }
        composable(route = Screen.EnigmeOneScreen.route) {
            Cinematic(
                painterResource(id = R.drawable.rezdechaussee),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.enigmeOneAlgo),
                Screen.ResolvEnigmeOneScreen,
                navController
            )
        }
        composable(route = Screen.ResolvEnigmeOneScreen.route) {
            resolvEnigmeOne(navController)

        }
        composable(route = Screen.ChoixEnigme1.route) {
            choixEnigmes(enigmes1 = Screen.EnigmeOneScreen,
                enigmes2 = Screen.EnigmeOneScreen,
                enigmes_nom = stringArrayResource(R.array.choix_enigmes1_nom),
                navController = navController)
        }
        composable(route = Screen.QCM.route){
            var item = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo)
            skillTest(navController,item)

        }
        composable(route = Screen.Cinematic2Screen.route) {
            Cinematic(
                painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic2),
                Screen.Cinematic3Screen,
                navController
            )
        }
        composable(route = Screen.Cinematic3Screen.route) {
            Cinematic(
                painterResource(id = R.drawable.hallcinematique1),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic3),
                Screen.MainScreen,
                navController
            )
        }


    }
}

