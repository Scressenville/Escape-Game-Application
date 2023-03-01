package sae.escapegame.application.android

import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.material.Text
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp

@Composable
fun EcranSplashReponseVA(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate("resultatA")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White))
        {
            Column() {
                Text(text = "Bravo vous avez gagner la lettre K !!!")
                Image(painter = painterResource(id = R.drawable.maevatrue),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(scale.value))
            }

    }
}
@Composable
fun EcranSplashReponseVS(navController: NavController) {
    var explication : Array<String> = stringArrayResource(R.array.ExplicationEnSQL)
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate("resultatS")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White))
    {
        Column {
            Text(text = "Bravo vous avez gagner la lettre B !!!")
            Image(painter = painterResource(id = R.drawable.sylvaintrue),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value))

        }

    }
}

@Composable
fun EcranSplashReponseFA(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(300L)
        navController.navigate("ecranLancementEnigmeAlgo")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Column {
            Image(painter = painterResource(id = R.drawable.leofalse),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value))
            Box(
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .background(Color.White)
                    .border(2.dp, Color.Black)
            ){

            }
        }

    }
}

@Composable
fun EcranSplashReponseFS(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(9000000000000000000L)
        navController.navigate("ecranLancementEnigmeSQL")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.leafalse),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .background(Color.White)
                    .border(2.dp, Color.Black)
            ){
                Column (
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize(),
                        ){
                    Text(" Raté : Regarde bien on cherche la note de BOB, est-ce le bon prénom?\n\n" +
                            " Regarde ta feuille d'indice, le squelette de ta requete est il correcte?  SELECT … FROM … WHERE \n\n" +
                            " Where sert à relier deux tables entre elle; Ici on veut les NOTES d'un ETUDIANT. " +
                            "Donc, on va avoir la structure suivante :\n WHERE NOTES.ETUDIANT = ETUDIANTS.IDETUDIANT"
                    )
                    Button(onClick = { navController.navigate("ecranLancementEnigmeSQL")},
                        border = BorderStroke(1.dp, Color.Red),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
                        Text(text = "Compris !", color = Color.DarkGray)
                    }
                }

            }
        }

    }
}