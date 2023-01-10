package sae.escapegame.application.android.QRCodeScan

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import sae.escapegame.application.android.AlerteDialogueParticipation
import sae.escapegame.application.android.Ecran

@Composable
fun EcranDeScanSQL(controlleurNavigation: NavController, booleanEnigmeSQL : Boolean) {

    if (!booleanEnigmeSQL) {
        controlleurNavigation.navigate(Ecran.EcranCinematiqueIntroSQL.route)
    }else {
        AlerteDialogueParticipation(controlleurNavigation)
    }
}