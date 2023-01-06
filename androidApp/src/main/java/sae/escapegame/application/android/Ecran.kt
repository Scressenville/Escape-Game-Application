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
    object EcranSplash : Ecran("ecranSplash")

    object EcranSQL : Ecran("QCM_SQL")
    object EcranSQLResultat: Ecran("SQL_Resultat")

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