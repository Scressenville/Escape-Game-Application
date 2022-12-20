package sae.escapegame.application.android

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun resolvEnigmeOne(navController : NavController){
    var imageVisible  by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

    ) {
            Image(

                painter = painterResource(R.drawable.enigmealgo),
                contentDescription = stringResource(R.string.enigmealgo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth()
            )
            Text("Sélectionner le code correspondant")
            Image(

                painter = painterResource(R.drawable.answer1),
                contentDescription = stringResource(R.string.answer1),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth()
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Mauvaise réponse", Toast.LENGTH_LONG).show()
                        }
                    )
            )
            Image(

                painter = painterResource(R.drawable.answer2),
                contentDescription = stringResource(R.string.answer2),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth()
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Bonne réponse", Toast.LENGTH_LONG).show()
                            navController.navigate(Screen.MainScreen.route)
                        }
                    )
            )
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
