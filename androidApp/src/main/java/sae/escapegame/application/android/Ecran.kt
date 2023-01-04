package sae.escapegame.application.android

sealed class Ecran(val route: String){

    object EcranPrincipal : Ecran("ecranPrincipal")

    object EcranCinématiqueRezDeChaussée : Ecran("ecranCinématiqueRezDeChaussée")
    object EcranCinematiquePremièreEtage : Ecran("ecranCinematiquePremièreEtage")
    object EcranCinématiqueDerniereEtage : Ecran("ecranCinématiqueDerniereEtage")
    object EcranCinématiqueIntroAlgo : Ecran("ecranCinématiqueIntroAlgo")
    object EcranCinématiqueIntroSQL : Ecran("CinématiqueIntroSQL")
    object EcranLancementEnigmeAlgo : Ecran("ecranLancementEnigmeAlgo")
    object EcranLancementEnigmeSQL : Ecran("ecranLancementEnigmeSQL")
    object EcranMenuPrincipal : Ecran("ecranMenuPrincipal")
    object EcranSplash : Ecran("ecranSplash")

    object QCM : Ecran("QCM_screen")
    object ResultatQCM: Ecran("ResultatQCM")

    fun avecArguments(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}