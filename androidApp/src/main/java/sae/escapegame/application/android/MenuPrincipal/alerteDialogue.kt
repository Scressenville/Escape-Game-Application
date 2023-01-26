package sae.escapegame.application.android


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AlerteDialogueParticipation(navController: NavController) {

    val context = LocalContext
        .current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Oups", color = Color.Black) },
            text = {
                Text(
                    text = "Vous avez déjà participé a cette épreuve",
                    color = Color.Black
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                        navController.navigate(Ecran.EcranMenuPrincipal.route)
                    }) {
                    Text(text = "OK", color = Color.Black)
                }

            },
            backgroundColor = Color.White,
            contentColor = Color.White
        )
    }
}

@Composable
fun AlerteDialogueRegle(navController: NavController) {

    val context = LocalContext
        .current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Regle", color = Color.Black) },
            text = {
                Text(
                    text = "--- Attend que la box du mot que tu as selectionné devienne plus grande avant de la deplacer.\n" +
                            "---Une fois que tu deposes un mot tu ne peux plus l'enveler.\n " +
                            "---Tu dois obligatoirement remplir les champs dans l'ordre.\n" ,
                    color = Color.Black
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                        navController.navigate(Ecran.EcranLancementEnigmeAlgo.route)
                    }) {
                    Text(text = "OK", color = Color.Black)
                }

            },
            backgroundColor = Color.White,
            contentColor = Color.White
        )
    }
}

@Composable
fun Didacticiel(navController: NavController) {
    var compteur by remember{mutableStateOf(0)}
    var dialogue = stringArrayResource(id = R.array.didacticiel)

    val context = LocalContext
        .current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Didacticiel", color = Color.Black) },
            text = {
                Text(text = dialogue[compteur], color = Color.Black)
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        if (dialogue.size -1> compteur){
                            compteur++
                        }
                        else{
                            openDialog.value = false
                            navController.navigate(Ecran.EcranMenuPrincipal.route)
                        }
                    }) {
                    Text(text = "OK", color = Color.Black)
                }

            },
            backgroundColor = Color(166, 110, 187, 255),
            contentColor = Color.White,
        )
    }
}
@Composable
fun AlerteDialogueAide(navController: NavController) {

    val context = LocalContext
        .current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Aide", color = Color.Black) },
            text = {
                Text(
                    text = "--- Attend que la box du mot que tu a selectionner devienne plus grand avant de le deplacer.\n" +
                            "---Une fois que tu depose un mot tu ne peut l'enveler.\n " +
                            "---Tu doit obligatoirement remplir les champs dans l'ordre.\n" ,
                    color = Color.Black
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                        navController.navigate(Ecran.EcranLancementEnigmeAlgo.route)
                    }) {
                    Text(text = "OK", color = Color.Black)
                }

            },
            backgroundColor = Color.White,
            contentColor = Color.White
        )
    }
}
@Composable
fun AlerteDialogSQL(navController: NavController,explication : String) {

    val context = LocalContext
        .current
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Explication", color = Color.Black) },
            text = {
                Text(
                    text = explication,
                    color = Color.Black
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                        navController.navigate(Ecran.EcranLancementEnigmeSQL.route)
                    }) {
                    Text(text = "OK", color = Color.Black)
                }

            },
            backgroundColor = Color.White,
            contentColor = Color.White
        )
    }
}