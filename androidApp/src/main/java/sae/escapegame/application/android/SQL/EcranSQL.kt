package sae.escapegame.application.android.SQL


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import sae.escapegame.application.android.Aide
import sae.escapegame.application.android.EcranSplashReponseFS
import sae.escapegame.application.android.R
import sae.escapegame.application.android.cinematics.OnBoardingData


@OptIn(ExperimentalPagerApi::class)
@Composable
fun EnigmeSQL(controllerNavigation: NavController){

    val items = ArrayList<OnBoardingData>()
    items.add(
        OnBoardingData(
            R.drawable.requettesqlfausse1
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.requettesqlfausse3
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.requettesqlvrai
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.requettesqlfausse2
        )
    )

    //------------ Suppression pour reglage difficulté abordable----------------
    //items.add(
    //    OnBoardingData(
    //        R.drawable.requettesqlfausse5
    //    )
    //)

    //items.add(
    //    OnBoardingData(
    //        R.drawable.requettesqlfausse4
    //    )
    //)

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
       navController = controllerNavigation
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    navController: NavController
){val aide = remember { mutableStateOf(false) }
    if(aide.value){
        Aide(aide, "Tu peux t'aider des indices présents  dans la salle")
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .background(Color(110, 128, 228, 255))

    ) {

        Image(
            painter = painterResource(id = R.drawable.bdd),
            contentDescription = "img",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(text = "Nous voulons savoir  la note de BOB\n"+
            "Quelle requete est correct ?\n"+"Aide toi des tables en haut!!",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
            Box(modifier = Modifier
                .fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),) {
                    HorizontalPager(state = pagerState) { page ->
                        Image(
                            painter = painterResource(id = item[page].image),
                            contentDescription = "img",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("Swipe à droite ou à gauche pour découvrir les différentes requetes :)")
                        Image(painter = painterResource(R.drawable.swipe),
                            contentDescription ="iconswipe",
                            modifier=Modifier
                                .fillMaxSize(0.3f)

                        )

                    }

                }
            }
        Column() {
            Text("Entre le chiffre de la reponse correcte")
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                modifier = Modifier
                    .background(Color(151, 151, 151, 255)),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                trailingIcon = {
                    IconButton(onClick = {
                        if (text == "3"){
                            navController.navigate("ecranSplashReponseVS")
                        }else{
                            navController.navigate("ecranSplashReponseFS")
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Check ,
                            contentDescription =  "OK")
                    }
                }
            )

        }
        Image(
            painter = painterResource(R.drawable.loggyaides),
            contentDescription = "avatarAideLoggy",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .clickable {
                    aide.value = true
                }
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(2.dp, Color.Black, CircleShape)
        )

    }
}


