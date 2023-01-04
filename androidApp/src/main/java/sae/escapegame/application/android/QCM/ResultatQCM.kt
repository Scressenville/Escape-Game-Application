package sae.escapegame.application.android.QCM

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp

@Composable
fun result(repJoueur: Array<String>, correctionQCM: Array<String>) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
            , verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                var affichage =comparaisonReponses(repJoueur, correctionQCM)
                Text("Resultats qcm"+" : "+affichage+" /4")


            }
        }
    }
    for (i in 0..3) {
       println(repJoueur[i])
        println("---- comparaison----------")
        println(correctionQCM[i])
        println("###### ligne suivante #####")
        println(comparaisonReponses(repJoueur, correctionQCM))
    }
}

fun comparaisonReponses(repJoueur: Array<String>, correctionQCM: Array<String>): Int {
    var points: Int = 0
    for (i in 0..3) {
        if(repJoueur[i] == correctionQCM[i]){
            points += 1
        }
    }
    return points
}
