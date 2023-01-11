package sae.escapegame.application.android.cinematics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import sae.escapegame.application.android.Ecran

@Composable
fun Explication(phrase : String, ecranSuivant : Ecran, controlleurNavigation : NavController){
    val couleurVerte : Color = Color(154, 246, 136)
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(modifier = Modifier
            .fillMaxSize(0.9f)
            .border(5.dp, couleurVerte, RoundedCornerShape(20.dp))
            .background(couleurVerte),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxSize(0.9f)
                .background(couleurVerte),
            ){Text(phrase, fontSize = 20.sp)}
        }
        Button(onClick = { controlleurNavigation.navigate(ecranSuivant.route) }) {
            Text("Suivant")
        }
    }
}