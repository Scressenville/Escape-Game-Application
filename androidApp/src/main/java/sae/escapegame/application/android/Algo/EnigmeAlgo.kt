package sae.escapegame.application.android.Algo

import android.widget.Button
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import sae.escapegame.application.android.*
import sae.escapegame.application.android.R


@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {
    val largeurEcran = LocalConfiguration.current.screenWidthDp
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.python_algo),
            contentDescription = "img",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            mainViewModel.items.forEach { person ->
                DragTarget(
                    dataToDrop = person,
                    viewModel = mainViewModel
                ) {
                    Box(
                        modifier = Modifier
                            .size(Dp(largeurEcran / 5f))
                            .clip(RoundedCornerShape(15.dp))
                            .shadow(5.dp, RoundedCornerShape(15.dp))
                            .background(person.backgroundColor, RoundedCornerShape(15.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = person.name,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }


        Text(
            text = "Traduit cet Algorithme en Python : ",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
        Button(onClick = {
            navController.navigate(Ecran.EcranLancementEnigmeAlgo.route)
                         },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)) {

            Image(
                    painterResource(id = R.drawable.reset),
            contentDescription ="reset",
            modifier = Modifier.size(20.dp))
            Text(text = "  Reinitialiser", color = Color.White)
        }

        var nom = "add"
        var i = 0
        var listenomverif: Array<String> =
            arrayOf("str", "print", "input", "print", "NomJoueur")
        var listenom = Array<String>(5) { nom }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(top = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                mainViewModel.addedWord.forEach { person ->
                    listenom.set(i, person.name)
                    i += 1

                }


                Text(
                    text = "  if __name__ == __main__ :", color = Color.White,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp
                )

                Row() {
                    Text(
                        text = "     NomJoueur :  ", color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp,
                    )
                    Drop(mainViewModel, text = listenom[0])

                }
                Row() {
                    Text(text = "      ")
                    Drop(mainViewModel, text = listenom[1])
                    Text(
                        text = " ('Quel est ton nom ?')",
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                }
                Row() {
                    Text(
                        text = "     NomJoueur = ",
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                    Drop(mainViewModel, text = listenom[2])
                    Text(
                        text = " ()",
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                }
                Row {
                    Text(text = "      ")
                    Drop(mainViewModel, text = listenom[3])
                    Text(
                        text = " (''moi'', ",
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                    Drop(mainViewModel, text = listenom[4])
                    Text(
                        text = " , ''je promets de vaincre '',", color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp
                    )
                }
                Text(
                    text = "  ''Chain et ainsi de mettre fin à ses crimes'')",
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp
                )
                Column(
                        horizontalAlignment = Alignment.Start
                        ) {
                    var bool by remember {
                        mutableStateOf(false)
                    }

                    TextButton(onClick = {
                        bool = true
                    }) {
                        Text(
                            text = "Quelque règle",
                            textAlign = TextAlign.Left
                        )
                        }
                    if (bool) {
                        AlerteDialogueRegle(navController)
                    }
                }
            }

            if (i == 5) {
                if (listenomverif.contentEquals(listenom)) {
                    navController.navigate(Ecran.EcranSplashReponseVA.route)
                } else {
                    navController.navigate(Ecran.EcranSplashReponseFA.route)
                }
            }
        }


    }
}


@Composable
private fun Drop(mainViewModel: MainViewModel,text:String){
    DropItem<WordUiItem>(
        modifier = Modifier
            .padding(0.dp)
    ) { isInBound, wordItem ->
        if (wordItem != null) {
            LaunchedEffect(key1 = wordItem) {
                mainViewModel.addWord(wordItem)
            }
        }
        if (isInBound) {
            Box(modifier = Modifier.background(Color.Gray)){
                Text(text = text,
                    color = Color.Red,
                    textAlign = TextAlign.Left,
                    fontSize = 30.sp)
            }

        } else {
            if (text == "add"){
                Text(text = text,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp)
            }else{
                Text(text = text,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp,
                    color = Color(175, 38, 85, 255)
                )
            }

        }
    }
}


