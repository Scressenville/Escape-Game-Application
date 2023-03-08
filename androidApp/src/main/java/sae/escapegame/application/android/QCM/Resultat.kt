package sae.escapegame.application.android.QCM

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResultatA(navController: NavController){
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
                .fillMaxWidth(), verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                    Text(
                        "Maintenant nous allons tester vos connaissance a traver un QCM\n" +
                                "Repondez juste et vous aurez 5 min en plus \n",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        navController.navigate("QCM_screen")
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Gray)
                ) {
                    Text(text = "Suivant", color = Color.DarkGray)
                }


            }
        }
    }
}
@Composable
fun ResultatS(navController: NavController){
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
                .fillMaxWidth(), verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Text(
                    "Maintenant nous allons tester vos connaissance à traver un QCM\n",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                Text(
                    text = "*Repondez juste et vous aurez 5 min en plus \n",
                    textAlign = TextAlign.Left,
                    fontSize = 10.sp)

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        navController.navigate("QCM_SQL")
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Gray)
                ) {
                    Text(text = "Suivant", color = Color.DarkGray)
                }


            }
        }
    }
}