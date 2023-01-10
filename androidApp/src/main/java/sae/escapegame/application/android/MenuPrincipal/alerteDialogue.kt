package sae.escapegame.application.android


import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
