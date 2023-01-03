package sae.escapegame.application.android.QCM

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun skillTest(navController: NavController, item: Array<String>, reponses: Array<String> ){
//quand carte cliquée changer couleur , on change valeur et apres on compare les reponses
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(15.dp, 50.dp)
        ) {
            Column(modifier = Modifier
                .padding(30.dp)
            ){
                Text("Test de connaissances : ")
                Text("Selectionne la/les reponse.s juste.s ! ")
                Text("Rose = Faux  Vert = Vrai")
            }
            Column(modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()

            ){

                Button(
                    modifier = Modifier
                        .padding(15.dp,15.dp)
                        .height(60.dp).width(500.dp)
                    ,

                    onClick = {
                        //your onclick code
                    },

                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text(text = item[0], color = Color.DarkGray)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp,15.dp)
                        .height(60.dp).width(500.dp)
                    ,
                    onClick = {
                        //your onclick code
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text(text = item[1], color = Color.DarkGray)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp,15.dp)
                        .height(60.dp).width(500.dp)
                    ,
                    onClick = {
                        //your onclick code
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text(text = item[2], color = Color.DarkGray)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp,15.dp)
                        .height(60.dp).width(500.dp)
                    ,
                    onClick = {
                        //your onclick code
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text(text = item[3], color = Color.DarkGray)
                }

            }
        }
    }
}