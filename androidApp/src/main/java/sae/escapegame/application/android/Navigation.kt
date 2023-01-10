package sae.escapegame.application.android

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import sae.escapegame.application.android.QCM.result
import sae.escapegame.application.android.QCM.verificationCapacite
import sae.escapegame.application.android.cinematics.Cinematique

@Composable
fun Navigation() {
    var repJoueur: Array<String> by remember { mutableStateOf(Array(4){""}) }
    var compteurQCM : Int by remember { mutableStateOf(0)}
    val navController = rememberNavController()
    var liste_qcm : Array<Array<String>> by remember { mutableStateOf(Array(3){Array(5){""} }) }
    var liste_reponse_qcm : Array<Array<String>> by remember { mutableStateOf(Array(3){Array(4){""} }) }
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
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

        composable(route = Ecran.EcranSplashReponseV.route){
            EcranSplashReponseV(navController)
        }

        composable(route = Ecran.EcranSplashReponseF.route){
            EcranSplashReponseF(navController)
        }

        composable(route = Ecran.EcranMenuPrincipal.route) {
            compteurQCM = 0
            MenuPrincipal(navController,Ecran.EcranCinematiqueIntroAlgo,Ecran.EcranCinematiqueIntroSQL)
        }
        composable(route = Ecran.EcranCinematiqueIntroAlgo.route) {
            Cinematique(
                painterResource(id = R.drawable.photo_rdc),
                painterResource(id = R.drawable.loggy),
                stringArrayResource(id = R.array.cinematiqueAlgo),
                Ecran.EcranLancementEnigmeAlgo,
                navController
            )
        }
        composable(route = Ecran.EcranLancementEnigmeSQL.route) {
            EnigmeSQL(navController)
        }

        composable(route = Ecran.EcranQCMAlgo.route){
            var qcm1 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo1)
            var qcm2 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmAlgo2)
            liste_qcm = arrayOf(qcm1,qcm2)
            var correctionQCM1Algo = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo1)
            var correctionQCM2Algo = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMAlgo2)
            liste_reponse_qcm = arrayOf(correctionQCM1Algo,correctionQCM2Algo)
            repJoueur = verificationCapacite(navController,liste_qcm[compteurQCM],liste_reponse_qcm[compteurQCM])
        }
        composable(route = Ecran.EcranAiguillageQCM.route){
            compteurQCM += 1
            if (compteurQCM<liste_qcm.size){
                navController.navigate(Ecran.EcranQCMAlgo.route)
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
            var qcm1 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmSQL1)
            var qcm2 = stringArrayResource(id = sae.escapegame.application.android.R.array.qcmSQL2)
            liste_qcm = arrayOf(qcm1,qcm2)
            var correctionQCM1SQL = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMSQL1)
            var correctionQCM2SQL = stringArrayResource(id = sae.escapegame.application.android.R.array.reponseQCMSQL2)
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
        }

    }
}

