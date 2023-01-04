package sae.escapegame.application.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun choixEnigmes(enigme1 : Ecran, enigme2 : Ecran, nomEnigme : Array<String>, controlleurNavigation: NavController){
    Column(modifier = Modifier
        .fillMaxHeight(0.9f)
        .fillMaxWidth()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text="Choisissez votre première épreuve !")
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = {controlleurNavigation.navigate(enigme1.route)}
            ) { Text(text = nomEnigme[0])}
            Button(
                onClick = {controlleurNavigation.navigate(enigme2.route)}
            ) { Text(text = nomEnigme[1])}
        }
    }
}