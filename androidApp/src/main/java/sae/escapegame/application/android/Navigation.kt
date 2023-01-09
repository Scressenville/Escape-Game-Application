package sae.escapegame.application.android

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.skillTest
import sae.escapegame.application.android.cinematics.Cinematique

@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4) { "" }) }
    var booleanEnigmeAlgo: Boolean by remember {
        mutableStateOf(false)
    }
    var booleanEnigmeSQL: Boolean by remember {
        mutableStateOf(false)
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Ecran.EcranPrincipal.route) {
        composable(route = Ecran.EcranPrincipal.route) {
            EcranPrincipal(controlleurNavigation = navController)
        }

        composable(route = Ecran.EcranCinematiqueRezDeChaussee.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic1),
                Ecran.EcranMenuPrincipal,
                navController
            )
        }

        composable(route = Ecran.EcranSplashReponseV.route) {
            EcranSplashReponseV(navController)
        }

        composable(route = Ecran.EcranSplashReponseF.route) {
            EcranSplashReponseF(navController)
        }

        composable(route = Ecran.EcranMenuPrincipal.route) {
            MenuPrincipal(navController,booleanEnigmeAlgo, booleanEnigmeSQL)
        }
        composable(route = Ecran.EcranCinematiqueIntroAlgo.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_rdc),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.enigmeOneAlgo),
                Ecran.EcranLancementEnigmeAlgo,
                navController
            )
        }
        composable(route = Ecran.EcranLancementEnigmeSQL.route) {
            SQL(navController)
        }

        composable(route = Ecran.QCM.route) {
            val item = stringArrayResource(id = R.array.qcmAlgo)
            repJoueur = skillTest(navController, item)
            println(repJoueur)
        }
        composable(route = Ecran.ResultatQCM.route) {
            val correctionQCM =
                stringArrayResource(id = R.array.reponseQCMAlgo)
            println(correctionQCM)
            result(repJoueur, correctionQCM, navController)
        }
        composable(route = Ecran.EcranSQL.route) {
            val item = stringArrayResource(id = R.array.qcmSQL)
            repJoueur = skillTest(navController, item)
            println(repJoueur)
        }

        composable(route = Ecran.EcranSQLResultat.route) {
            val correctionQCM =
                stringArrayResource(id = R.array.reponseQCMSQL)
            println(correctionQCM)
            result(repJoueur, correctionQCM, navController)
        }

        composable(route = Ecran.EcranCinematiquePremierEtage.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic2),
                Ecran.EcranCinematiqueDerniereEtage,
                navController
            )
        }
        composable(route = Ecran.EcranCinematiqueDerniereEtage.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic3),
                Ecran.EcranPrincipal,
                navController
            )
        }
        composable(route = Ecran.EcranLancementEnigmeAlgo.route) {
            resoudrePremiereEnigme(controlleurNavigation = navController)
            booleanEnigmeAlgo = true
        }
        composable(route = Ecran.EcranCinematiqueIntroSQL.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_r47),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematic1),
                Ecran.EcranLancementEnigmeSQL,
                navController
            )
            booleanEnigmeSQL  = true
        }

    }
}

