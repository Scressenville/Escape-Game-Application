package sae.escapegame.application.android

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun enigmeOne(){
    var compteur by remember{ mutableStateOf(0) }
    var dialogue = stringArrayResource(R.array.enigmeOneAlgo)
    var imageVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
    ){
        AnimatedVisibility(
            visible = !imageVisible,
            enter = fadeIn(animationSpec = tween(2000)),
            exit = fadeOut(animationSpec = tween(2000))
        ) {
            Image(

                painter = painterResource(sae.escapegame.application.android.R.drawable.enigmealgo),
                contentDescription = stringResource(sae.escapegame.application.android.R.string.enigmealgo),
                modifier = Modifier
                    .padding(horizontal = 5.dp)

            )
        }
            Text(dialogue[compteur])
            Button(
                onClick = {
                    if (dialogue.size -1 > compteur){
                        compteur++
                    } else{
                        imageVisible = !imageVisible
                    }

                },
            ) {
                Text(stringResource(R.string.btnSuivant))
            }
        }

    }
