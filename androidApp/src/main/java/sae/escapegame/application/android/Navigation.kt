package sae.escapegame.application.android

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import sae.escapegame.application.android.Algo.DragableScreen
import sae.escapegame.application.android.Algo.MainScreen
import sae.escapegame.application.android.Algo.MainViewModel
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.verificationCapacite
import sae.escapegame.application.android.SQL.EnigmeSQL
import sae.escapegame.application.android.cinematics.Cinematique
import sae.escapegame.application.android.cinematics.Explication


@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4){""}) }
    var compteurQCM : Int by remember { mutableStateOf(0)}
    val navController = rememberNavController()
    var liste_qcm : Array<Array<String>> by remember { mutableStateOf(Array(3){Array(5){""} }) }
    var liste_reponse_qcm : Array<Array<String>> by remember { mutableStateOf(Array(3){Array(4){""} }) }
    var EcranQCM : Ecran = Ecran.EcranQCMAlgo
    var ecranSuivant : Ecran = Ecran.EcranMenuPrincipal
    var listePhraseExplication : Array<String> by remember {mutableStateOf(Array(5){""})}
    var phraseExplication : String by remember {mutableStateOf("")}
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
                stringArrayResource(id = R.array.cinematiqueRezDeChaussée),
                Ecran.EcranMenuPrincipal,
                navController
            )
        }

        composable(route = Ecran.EcranSplashReponseVA.route){
            EcranSplashReponseVA(navController)
        }
        composable(route = Ecran.EcranSplashReponseVS.route){
            EcranSplashReponseVS(navController)
        }

        composable(route = Ecran.EcranSplashReponseFA.route){
            EcranSplashReponseFA(navController)
        }

        composable(route = Ecran.EcranSplashReponseFS.route){
            EcranSplashReponseFS(navController)
        }


        composable(route = Ecran.EcranMenuPrincipal.route) {
            compteurQCM = 0
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
            if(booleanEnigmeAlgo==false && booleanEnigmeSQL == false){
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
                stringArrayResource(id = R.array.cinematiqueAlgo),
                Ecran.EcranLancementEnigmeAlgo,
                navController
            )
            booleanEnigmeAlgo = true
        }
        composable(route = Ecran.EcranLancementEnigmeSQL.route) {
            EnigmeSQL(navController)
        }

        composable(route = Ecran.EcranQCMAlgo.route){
            EcranQCM = Ecran.EcranQCMAlgo
            val qcmAlgo1 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo1)
            val qcmAlgo2 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo2)
            liste_qcm = arrayOf(qcmAlgo1,qcmAlgo2)
            val correctionQCM1Algo = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo1)
            val correctionQCM2Algo = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo2)
            liste_reponse_qcm = arrayOf(correctionQCM1Algo,correctionQCM2Algo)
            repJoueur = verificationCapacite(navController,liste_qcm[compteurQCM],liste_reponse_qcm[compteurQCM])
        }
        composable(route = Ecran.EcranAiguillageQCM.route){
            compteurQCM += 1
            if (compteurQCM<liste_qcm.size){
                navController.navigate(EcranQCM.route)
            }
            else{
                compteurQCM = 0
                navController.navigate(Ecran.EcranMenuPrincipal.route)
            }

        }
        composable(route = Ecran.EcranFonctionResultatQCM.route){
            result(repJoueur, liste_reponse_qcm[compteurQCM],navController)
        }
        composable(route = Ecran.EcranQCMSQL.route){
            EcranQCM = Ecran.EcranQCMSQL
            val qcmSQL1 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmSQL1)
            val qcmSQL2 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmSQL2)
            liste_qcm = arrayOf(qcmSQL1,qcmSQL2)
            println(liste_qcm[1])
            val correctionQCM1SQL = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMSQL1)
            val correctionQCM2SQL = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMSQL2)
            liste_reponse_qcm = arrayOf(correctionQCM1SQL,correctionQCM2SQL)
            repJoueur = verificationCapacite(navController,liste_qcm[compteurQCM], liste_reponse_qcm[compteurQCM])
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
            val viewModel = MainViewModel()
                DragableScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(120, 96, 124, 255))
                ) {
                    MainScreen(viewModel,navController)
                }
            phraseExplication = stringResource(R.string.explicationEnigmeAlgo)
            ecranSuivant = Ecran.EcranQCMAlgo
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
        composable(route = Ecran.EcranExplication.route){
            Explication(phrase = phraseExplication, ecranSuivant = ecranSuivant, controlleurNavigation = navController)
        }

    }
}

