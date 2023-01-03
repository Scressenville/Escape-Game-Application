package sae.escapegame.application.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.clickable

import androidx.compose.runtime.*

import androidx.navigation.NavController

@Composable
fun MenuPrincipal(enigme1 : Ecran, enigme2 : Ecran, nomEnigme : Array<String>, controlleurNavigation: NavController) {
    var qrcode by remember{ mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (qrcode == false) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .fillMaxHeight()
                        .padding(start = 0.dp, 30.dp, 0.dp, 0.dp)
                        .background(Color.LightGray),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.symbole_inventaire),
                        contentDescription = "Inventaire",
                        modifier = Modifier.clickable {})

                    Image(
                        painter = painterResource(R.drawable.symbole_sauvegarde),
                        contentDescription = "Sauvegarde",
                        modifier = Modifier.clickable {})

                    Image(
                        painter = painterResource(R.drawable.symbole_aide),
                        contentDescription = "Aide",
                        modifier = Modifier.clickable {})

                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceAround
                )
                {
                    Text(
                        text = "40:00",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(R.drawable.plan_rdc),
                        contentDescription = "Image de l'étage",
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                }
            }
        }
        else {
            choixEnigmes(enigme1 = enigme1, enigme2 = enigme2, nomEnigme = nomEnigme, controlleurNavigation = controlleurNavigation)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround
        )
        {
            Image(
                painter = painterResource(R.drawable.symbole_ecran_principal),
                contentDescription = "MenuPrinciapal",
                modifier = Modifier.clickable {
                    if (qrcode == true) {
                        qrcode = false
                    }
                })

            Image(
                painter = painterResource(R.drawable.symbole_qr_code),
                contentDescription = "Qrcode",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .clickable {
                        if (qrcode == false) {
                            qrcode = true
                        }
                    })
        }
    }
}