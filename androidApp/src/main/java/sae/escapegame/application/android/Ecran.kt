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
    object EcranSplashReponseVA : Ecran("ecranSplashReponseVA")
    object EcranSplashReponseVS : Ecran("ecranSplashReponseVS")
    object EcranSplashReponseFA : Ecran("ecranSplashReponseFA")
    object EcranSplashReponseFS : Ecran("ecranSplashReponseFS")
    object EcranFonctionResultatQCM : Ecran("ecranFonctionResultatQCM")
    object EcranExplication : Ecran("ecranExplication")
    object AlerteDialogueRegle : Ecran("alerteDialogueRegle")

    object EcranDidacticiel : Ecran("didacticiel")
    object EcranQCMSQL : Ecran("QCM_SQL")

    object EcranQCMAlgo : Ecran("QCM_screen")
    object EcranAiguillageQCM: Ecran("EcranAiguillageQCM")

    object EcranResultatA : Ecran("resultatA")
    object EcranResultatS : Ecran("resultatS")

}