package sae.escapegame.application.android

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource

@Composable
fun Navigation() {
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

        composable(route = Ecran.EcranDetails.route) {
            EcranPremiereCinematique(controlleurNavigation = navController)
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
        composable(route = Ecran.ChoixEnigmeUn.route) {
            choixEnigmes(enigme1 = Ecran.EcranPremiereEnigme,
                enigme2 = Ecran.EcranPremiereEnigme,
                nomEnigme = stringArrayResource(R.array.choix_enigmes1_nom),
                controlleurNavigation = navController)
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

        composable(route = Ecran.EcranMenuPrincipal.route) {
            MenuPrincipal(Ecran.EcranPremiereEnigme,Ecran.EcranPremiereEnigme,stringArrayResource(R.array.choix_enigmes1_nom),navController)
        }


    }
}

