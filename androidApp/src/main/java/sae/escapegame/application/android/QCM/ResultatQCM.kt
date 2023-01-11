package sae.escapegame.application.android.QCM

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import sae.escapegame.application.android.R

@Composable
fun result(repJoueur: Array<String>, correctionQCM: Array<String>,controllerNavigation: NavController) {
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    val scale = remember {
        Animatable(0f)
    }
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
                var score =comparaisonReponses(repJoueur, correctionQCM)

                    Text("Félicitations, tu as résolu l'énigme ! ")
                    Text("/!/ nouvelle lettre obtenue")
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().background(Color.Yellow))
                        {if(score==4){
                        Image(
                            painter = painterResource(id = R.drawable.lea_true),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Logo",
                            modifier = Modifier
                                .scale(scale.value)
                                .fillMaxSize()
                        )

                        }else{
                            println("perdu")
                            Image(painter = painterResource(id = R.drawable.lea_false),
                                contentScale = ContentScale.Fit,
                                contentDescription = "Logo",
                                modifier = Modifier.scale(scale.value))
                }}
                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp).width(500.dp),
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
