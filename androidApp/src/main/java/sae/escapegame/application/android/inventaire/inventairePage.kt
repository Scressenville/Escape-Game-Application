package sae.escapegame.application.android.inventaire

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sae.escapegame.application.android.R

@Composable
fun EcranInventaire(controlleurNavigation: NavController, inventaire: inventaire){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White))
    {
        Column() {
            Row() {
                if(inventaire.K){
                    Image(painter = painterResource(id = R.drawable.k),
                        contentDescription = "Lettre K",
                        modifier = Modifier
                            .padding(16.dp)
                            .width(200.dp)
                            .height(200.dp)
                    )
                }
                if(inventaire.B){
                    Image(painter = painterResource(id = R.drawable.b),
                        contentDescription = "Lettre B",
                        modifier = Modifier
                            .padding(16.dp)
                            .width(200.dp)
                            .height(200.dp)
                    )
                }
            }
            if(inventaire.O){
                Text(
                    text = "O"
                )
            }
        }
    }
}