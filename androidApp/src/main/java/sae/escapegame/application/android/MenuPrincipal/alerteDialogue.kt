package sae.escapegame.application.android


import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
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
            title = { Text(text = "Didacticiel", color = Color.White) },
            text = {
                Text(text = dialogue[compteur], color = Color.White)
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
                    Text(text = "  ->", color = Color.White)
                }
                            },
                dismissButton = {
                    if(compteur != 0){
                        TextButton(

                            onClick = {
                                if (dialogue.size -1> compteur){
                                    compteur--
                                }
                            }) {
                            Text("<-  ",color= Color.White)
                        }
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
@Composable
fun Aide(aide: MutableState<Boolean>) : MutableState<Boolean> {
    println("je passe dans la fonction aide")

    var showDialog by remember { mutableStateOf(true )}
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Help Loggy") },
            text = { Text("Je viens t'aider ! ") },
            confirmButton = {
                Button(
                    onClick = {
                        // Actions à effectuer lors de la confirmation
                        showDialog = false
                    }
                ) {
                    Text("Confirmer")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Actions à effectuer lors de l'annulation
                        showDialog = false
                        aide.value = false
                    }
                ) {
                    Text("Annuler")
                }
            }
        )
    }
    return aide
}
