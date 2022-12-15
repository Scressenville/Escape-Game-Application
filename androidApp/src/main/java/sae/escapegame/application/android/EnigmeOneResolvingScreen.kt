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
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun resolvEnigmeOne(){
    var imageVisible  by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        AnimatedVisibility(
            visible = !imageVisible,
            enter = fadeIn(animationSpec = tween(4000)),
            exit = fadeOut(animationSpec = tween(4000))
        ) {
            Image(

                painter = painterResource(R.drawable.enigmealgo),
                contentDescription = stringResource(R.string.enigmealgo),
                modifier = Modifier
                    .padding(horizontal = 5.dp)

            )
            Text("Selectionne la bonne réponse")
            Image(
                painter = painterResource(R.drawable.answer1),
                contentDescription = stringResource(R.string.answer1),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Image(
                painter = painterResource(R.drawable.answer2),
                contentDescription = stringResource(R.string.answer2),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            }

        }
    }

@Composable
fun OutlineTextFieldSample() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Answer") },
        onValueChange = {
            text = it
        }
    )
}
