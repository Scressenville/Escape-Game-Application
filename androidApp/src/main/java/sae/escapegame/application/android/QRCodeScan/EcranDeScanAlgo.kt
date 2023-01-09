package sae.escapegame.application.android.QRCodeScan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import sae.escapegame.application.android.AlerteDialogue
import sae.escapegame.application.android.Ecran
import sae.escapegame.application.android.EcranDeScan

@Composable
fun EcranDeScanAlgo(controlleurNavigation: NavController, booleanEnigmeAlgo : Boolean) {

    if (!booleanEnigmeAlgo) {
        controlleurNavigation.navigate(Ecran.EcranCinematiqueIntroAlgo.route)
    }else {
        AlerteDialogue(controlleurNavigation)
    }
}