package sae.escapegame.application.android


import android.graphics.Color.WHITE
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource

@Composable
fun Cinematic1Screen(){
    var compteur by remember{mutableStateOf(0)}
    var dialogue = stringArrayResource(R.array.cinematic1)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ){
        Text(dialogue[compteur])
        Button(
            onClick = {
                if (dialogue.size -1 > compteur){
                    compteur++
                }
            },
        ) {
            Text(stringResource(R.string.btnSuivant))
        }

    }
}