package sae.escapegame.application.android

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.skillTest
import sae.escapegame.application.android.cinematics.Cinematique

@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4){""}) }
    val navController = rememberNavController()
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    var booleanEnigmeAlgo = false
    var booleanEnigmeSQL = false
    NavHost(navController = navController, startDestination = Ecran.EcranPrincipal.route ) {
        composable(route = Ecran.EcranPrincipal.route) {

            EcranPrincipal(controlleurNavigation = navController)
        }

        composable(route = Ecran.EcranCinematiqueRezDeChaussee.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiqueAlgo),
                Ecran.EcranMenuPrincipal,
                navController
            )
        }

        composable(route = Ecran.EcranSplashReponseV.route){
            EcranSplashReponseV(navController)
        }

        composable(route = Ecran.EcranSplashReponseF.route){
            EcranSplashReponseF(navController)
        }

        composable(route = Ecran.EcranMenuPrincipal.route) {
            println("Algo:"+booleanEnigmeAlgo)
            println("=============================")
            println("SQL"+booleanEnigmeSQL)
            if(booleanEnigmeAlgo==true && booleanEnigmeSQL==false){
                MenuPrincipal(navController,booleanEnigmeAlgo,booleanEnigmeSQL,  painterResource(id = R.drawable.plan_rdc_r47_ok))
            }
            if(booleanEnigmeAlgo==false && booleanEnigmeSQL==true){
                MenuPrincipal(navController,booleanEnigmeAlgo,booleanEnigmeSQL,  painterResource(id = R.drawable.plan_rdc_r50_ok))
            }
            if(booleanEnigmeAlgo==true && booleanEnigmeSQL==true){
                MenuPrincipal(navController,booleanEnigmeAlgo,booleanEnigmeSQL,  painterResource(id = R.drawable.plan_rdc_r47_r50_ok))
            }
            if(booleanEnigmeAlgo==false && booleanEnigmeAlgo == false){
                MenuPrincipal(
                    navController,
                    booleanEnigmeAlgo,
                    booleanEnigmeSQL,
                    painterResource(id = R.drawable.plan_rdc_rienvalide)
                )
            }
        }
        composable(route = Ecran.EcranCinematiqueIntroAlgo.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_rdc),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiqueRezDeChaussée),
                Ecran.EcranLancementEnigmeAlgo,
                navController
            )
            booleanEnigmeAlgo = true
        }
        composable(route = Ecran.EcranLancementEnigmeSQL.route) {
            SQL(navController)
        }

        composable(route = Ecran.QCM.route){
            var item = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo1)
            repJoueur = skillTest(navController,item)
            println(repJoueur)
        }
        composable(route = Ecran.ResultatQCM.route){
            var correctionQCM = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo1)
            println(correctionQCM)
            result(repJoueur, correctionQCM,navController)
        }
        composable(route = Ecran.EcranSQL.route){
            val item = stringArrayResource(id = sae.escapegame.application.android.R.array.enigmesSQL)
            repJoueur = skillTest(navController,item)
            println(repJoueur)
        }

        composable(route = Ecran.EcranSQLResultat.route){
            var correctionQCM = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo1)
            println(correctionQCM)
            result(repJoueur, correctionQCM,navController)
        }

        composable(route = Ecran.EcranCinematiquePremierEtage.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiquePremiereEtage),
                Ecran.EcranCinematiqueDerniereEtage,
                navController
            )
        }
        composable(route = Ecran.EcranCinematiqueDerniereEtage.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_hall),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiqueDeuxiemeEtage),
                Ecran.EcranPrincipal,
                navController
            )
        }
        composable(route = Ecran.EcranLancementEnigmeAlgo.route){
            resoudrePremiereEnigme(controlleurNavigation = navController)
        }
        composable(route = Ecran.EcranCinematiqueIntroSQL.route){
            Cinematique(
                painterResource(id = R.drawable.photo_r47),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiqueSQL),
                Ecran.EcranLancementEnigmeSQL,
                navController
            )
            booleanEnigmeSQL = true
        }

    }
}

