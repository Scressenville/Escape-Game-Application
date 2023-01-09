package sae.escapegame.application.android

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EcranPrincipal(controlleurNavigation: NavController){
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.titre_escape_game),
            contentDescription = "Titre escape game",
            modifier = Modifier
                .height(40.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.loggy),
            contentDescription = "Loggy",
            modifier = Modifier
                .height(200.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = {
                controlleurNavigation.navigate(Ecran.EcranCinematiqueRezDeChaussee.route)
            },
        ) {
            Text(stringResource(sae.escapegame.application.android.R.string.btnJouer))
        }


    }
}


