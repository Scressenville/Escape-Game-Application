package sae.escapegame.application.android

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun enigmeOne(navController : NavController){
    var compteur by remember{ mutableStateOf(0) }
    var dialogue = stringArrayResource(R.array.enigmeOneAlgo)
    var imageVisible by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
    ){
            Text(dialogue[compteur])
                Button(
                    onClick = {
                        if (dialogue.size -1 > compteur){
                            compteur++
                        }
                        else{
                            navController.navigate(Screen.ResolvEnigmeOneScreen.route)
                        }
                    },
                ) {

                       Text(stringResource(R.string.btnSuivant))
                       // faire une autre scene pour passer à la resolution de l'equation
                }
            }

        }

