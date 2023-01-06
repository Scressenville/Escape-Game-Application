package sae.escapegame.application.android.cinematics


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sae.escapegame.application.android.Ecran
import sae.escapegame.application.android.R

@Composable
fun Cinematique(imageFond: Painter, imageLoggy: Painter, dialogue : Array<String>, sceneSuivante : Ecran, controlleurNavigation : NavController){
    var compteur by remember{mutableStateOf(0)}
    val gradient =
        Brush.horizontalGradient(listOf(Color.Yellow, Color.Red))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Box(modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()) {
            Card(modifier = Modifier.fillMaxWidth())
            {
                Image(
                    painter = imageFond,
                    contentDescription = "Fond",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Image(
                painter = imageLoggy,
                contentDescription = "Loggy",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .width(150.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(5.dp, Color.Black)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )
        {
            Text(dialogue[compteur],textAlign = TextAlign.Center,modifier = Modifier.height(100.dp).width(400.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Black),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom

            )
            {
                if (compteur != 0){
                    Button(
                        onClick = {
                            if (0 < compteur){
                                compteur--
                            }
                        }
                    ) { Text(text = stringResource(R.string.btnPrecedemment))}
                }
                
                Button(
                    onClick = {
                        if (dialogue.size -1> compteur){
                            compteur++
                        }
                        else{
                            controlleurNavigation.navigate(sceneSuivante.route)
                        }
                    }
                ) { Text(text = stringResource(R.string.btnSuivant))}
            }
        }
    }
}
