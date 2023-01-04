package sae.escapegame.application.android
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.skillTest

@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4){""}) }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Ecran.EcranPrincipal.route ) {
        composable(route = Ecran.EcranPrincipal.route) {
            EcranPrincipal(controlleurNavigation = navController)
        }

        composable(route = Ecran.EcranPremiereCinematique.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic1),
                Ecran.EcranMenuPrincipal,
                navController
            )
        }
        composable(route = Ecran.EcranMenuPrincipal.route) {
            MenuPrincipal(Ecran.EcranPremiereEnigme,Ecran.EcranEnigmeSQL,stringArrayResource(R.array.choix_enigmes1_nom),navController)
        }
        composable(route = Ecran.EcranPremiereEnigme.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_rdc),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.enigmeOneAlgo),
                Ecran.EcranResolutionPremiereEnigme,
                navController
            )
        }
        composable(route = Ecran.EcranResolutionPremiereEnigme.route) {
            resoudrePremiereEnigme(navController)

        }
        composable(route = Ecran.ChoixEnigme1.route) {
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
        composable(route = Ecran.ResultatQCM.route){
            var correctionQCM = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo)
            println(correctionQCM)
            result(repJoueur, correctionQCM)
        }

        composable(route = Ecran.EcranDeuxiemeCinematique.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic2),
                Ecran.EcranTroisiemeCinematique,
                navController
            )
        }
        composable(route = Ecran.EcranTroisiemeCinematique.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic3),
                Ecran.EcranPrincipal,
                navController
            )
        }
        composable(route = Ecran.EcranEnigmeSQL.route){
            SQL()
        }
    }
}

