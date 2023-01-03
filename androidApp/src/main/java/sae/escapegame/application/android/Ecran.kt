package sae.escapegame.application.android

sealed class Ecran(val route: String){

    object EcranPrincipal : Ecran("ecranPrincipal")

    object EcranPremiereCinematique : Ecran("ecranPremiereCinematique")
    object EcranDeuxiemeCinematique : Ecran("ecranDeuxiemeCinematique")
    object EcranTroisiemeCinematique : Ecran("ecranTroisiemeCinematique")
    object EcranPremiereEnigme : Ecran("ecranPremiereEnigme")
    object EcranResolutionPremiereEnigme : Ecran("ecranResolutionPremiereEnigme")
    object EcranMenuPrincipal : Ecran("ecranMenuPrincipal")


    fun avecArguments(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}