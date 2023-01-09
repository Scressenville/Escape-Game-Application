package sae.escapegame.application.android.QCM

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import sae.escapegame.application.android.Ecran
import androidx.compose.material.Button
import androidx.navigation.NavController

@Composable
fun result(repJoueur: Array<String>, correctionQCM: Array<String>, controllerNavigation: NavController) {
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
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
                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp).width(500.dp),
                    onClick = {
                        controllerNavigation.navigate(Ecran.EcranMenuPrincipal.route)
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Gray)
                ) {
                    Text(text = "HOME", color = Color.DarkGray)
                }



            }
        }
    }
    //debug console
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
