package sae.escapegame.application.android
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.skillTest

@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4){""}) }

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
            repJoueur = skillTest(navController,item)
            println(repJoueur)
        }
        composable(route = Screen.ResultatQCM.route){
            var correctionQCM = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo)
            println(correctionQCM)
            result(repJoueur, correctionQCM)
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

