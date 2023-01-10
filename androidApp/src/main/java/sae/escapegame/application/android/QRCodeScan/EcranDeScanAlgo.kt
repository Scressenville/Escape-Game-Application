package sae.escapegame.application.android.QRCodeScan

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import sae.escapegame.application.android.AlerteDialogueParticipation
import sae.escapegame.application.android.Ecran

@Composable
fun EcranDeScanAlgo(controlleurNavigation: NavController, booleanEnigmeAlgo : Boolean) {

    if (!booleanEnigmeAlgo) {
        controlleurNavigation.navigate(Ecran.EcranCinematiqueIntroAlgo.route)
    }else {
        AlerteDialogueParticipation(controlleurNavigation)
    }
}