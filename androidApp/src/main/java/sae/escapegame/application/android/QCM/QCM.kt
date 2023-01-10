package sae.escapegame.application.android.QCM

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sae.escapegame.application.android.Ecran

@Composable
fun skillTest(navController: NavController, liste_qcm: Array<String>,liste_reponse_qcm: Array<String> ): Array<String> {
    var selectedA by remember { mutableStateOf(false) }
    var selectedB by remember { mutableStateOf(false) }
    var selectedC by remember { mutableStateOf(false) }
    var selectedD by remember { mutableStateOf(false) }
    val colorA = if (selectedA) Color.Green else Color.Red
    val colorB = if (selectedB) Color.Green else Color.Red
    val colorC = if (selectedC) Color.Green else Color.Red
    val colorD = if (selectedD) Color.Green else Color.Red
    var a: Boolean by remember { mutableStateOf(false) }
    var b: Boolean by remember { mutableStateOf(false) }
    var c: Boolean by remember { mutableStateOf(false) }
    var d: Boolean by remember { mutableStateOf(false) }
    var repJoueur: Array<String> by remember { mutableStateOf(Array(5){""})}
    var valider : Boolean by remember {mutableStateOf(false)}
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth(), verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                Text("Test de connaissances : ")
                Text("Selectionne la/les reponse.s juste.s ! ")
                Text(liste_qcm[0])
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth()

            ) {
                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {//quand carte cliquée changer couleur
                        selectedA = !selectedA
                        // on change valeur
                        a = !a
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorA)
                ) {
                    Text(text = liste_qcm[1], color = Color.DarkGray)

                }

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        selectedB = !selectedB
                        b = !b
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorB)
                ) {

                    Text(text = liste_qcm[2], color = Color.DarkGray)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),

                    onClick = {
                        selectedC = !selectedC
                        c = !c
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorC)
                ) {

                    Text(text = liste_qcm[3], color = Color.DarkGray)
                }

                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        selectedD = !selectedD
                        d = !d
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = colorD)
                ) {
                    Text(text = liste_qcm[4], color = Color.DarkGray)
                }
                Button(
                    modifier = Modifier
                        .padding(15.dp, 15.dp)
                        .height(60.dp)
                        .width(500.dp),
                    onClick = {
                        valider = true
                    },
                    border = BorderStroke(1.dp, Color.Red),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Gray)
                )
                {
                    Text(text = "Valider", color = Color.DarkGray)
                }
                if (valider == true){
                    repJoueur = arrayOf(a.toString(),b.toString(),c.toString(),d.toString())
                    println(a.toString()+b.toString()+c.toString()+d.toString())
                    navController.navigate(Ecran.EcranFonctionResultatQCM.route)
                }
            }
        }
    }
    return repJoueur
}


