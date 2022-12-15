package sae.escapegame.application.android

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun choixEnigmes(enigmes_screen : Array<Screen>,enigmes_nom : Array<String> , navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
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
                onClick = {navController.navigate(enigmes_screen[0].route)}
            ) { Text(text = enigmes_nom[0])}
            Button(
                onClick = {navController.navigate(enigmes_screen[1].route)}
            ) { Text(text = enigmes_nom[1])}
        }
    }
}