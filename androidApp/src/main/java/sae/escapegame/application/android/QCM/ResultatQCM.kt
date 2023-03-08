package sae.escapegame.application.android.QCM

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sae.escapegame.application.android.Ecran


@Composable
fun result(repJoueur: Array<String>, correctionQCM: Array<String>,controllerNavigation: NavController) {
    val explication = "COUOU"
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
                if (affichage == 4){
                    Image(painter = painterResource(id = sae.escapegame.application.android.R.drawable.leatrue),
                        contentDescription = "img")
                    Text("Bravo vous avez reussi !!!!!",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp)
                    Column(
                        Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.LightGray)
                            .align(Alignment.CenterHorizontally)
                    ){
                        Text(explication ,modifier = Modifier.padding(16.dp))
                    }
                }else{
                    Image(painter = painterResource(id = sae.escapegame.application.android.R.drawable.maevafalse),
                        contentDescription = "img" )
                    Text("Dommage vous avez eu faux ",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        controllerNavigation.navigate(Ecran.EcranAiguillageQCM.route)
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Gray)
                ) {
                    Text(text = "Suivant", color = Color.DarkGray)
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
