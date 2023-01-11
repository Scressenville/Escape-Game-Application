package sae.escapegame.application.android

sealed class Ecran(val route: String){

    object EcranPrincipal : Ecran("ecranPrincipal")

    object EcranCinematiqueRezDeChaussee : Ecran("ecranCinématiqueRezDeChaussée")
    object EcranCinematiquePremierEtage : Ecran("ecranCinematiquePremièreEtage")
    object EcranCinematiqueDerniereEtage : Ecran("ecranCinématiqueDerniereEtage")
    object EcranCinematiqueIntroAlgo : Ecran("ecranCinématiqueIntroAlgo")
    object EcranCinematiqueIntroSQL : Ecran("CinématiqueIntroSQL")
    object EcranLancementEnigmeAlgo : Ecran("ecranLancementEnigmeAlgo")
    object EcranLancementEnigmeSQL : Ecran("ecranLancementEnigmeSQL")
    object EcranMenuPrincipal : Ecran("ecranMenuPrincipal")
    object EcranSplashReponseV : Ecran("ecranSplashReponseV")
    object EcranSplashReponseF : Ecran("ecranSplashReponseF")
    object EcranFonctionResultatQCM : Ecran("ecranFonctionResultatQCM")
    object EcranExplication : Ecran("ecranExplication")
    object EcranQCMSQL : Ecran("QCM_SQL")

    object EcranQCMAlgo : Ecran("QCM_screen")
    object EcranAiguillageQCM: Ecran("EcranAiguillageQCM")

    fun avecArguments(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}