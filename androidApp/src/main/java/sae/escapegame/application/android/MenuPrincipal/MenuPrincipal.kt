package sae.escapegame.application.android


import android.annotation.SuppressLint
import android.widget.ImageButton
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import sae.escapegame.application.android.MenuPrincipal.MenuItem
import sae.escapegame.application.android.QRCodeScan.EcranDeScanAlgo
import sae.escapegame.application.android.QRCodeScan.EcranDeScanSQL


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MenuPrincipal(
    controlleurNavigation: NavController,
    tempsDepart : Int,
    booleanEnigmeAlgo: Boolean, booleanEnigmeSQL: Boolean, booleanDidacticiel: Boolean, planActuel: Painter) {


    var qrcode by remember{ mutableStateOf(false) }
    val aide = remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    if (!booleanDidacticiel){
        Didacticiel(controlleurNavigation)
    }

    if(aide.value){
        Aide(aide," Rends toi sur une des deux salles indiquées sur le plan. \n Ensuite, clique sur le bouton de scan en bas à droite puis scanne le QR code présent sur le mur pour accéder à l'énigme.")
    }
    if(booleanEnigmeAlgo && booleanEnigmeSQL){
        controlleurNavigation.navigate("enigmeFin")

    }



    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    Scaffold(

        // pass the scaffold state
        scaffoldState = scaffoldState,

        topBar = {
            MyTopAppBar(tempsDepart) {
                // open the drawer
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },

        drawerContent = {
            MyNavigationDrawer(coroutineScope = coroutineScope, scaffoldState = scaffoldState, controlleurNavigation)

        },

        bottomBar = {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement
                    .spacedBy(
                        space= 50.dp,
                        alignment= Alignment.CenterHorizontally
                    ),
                verticalAlignment = Alignment.Bottom

            ) {
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
                if (qrcode ==false) {
                    Image(
                        painter = painterResource(R.drawable.symbole_qr_code),
                        contentDescription = "Qrcode",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier

                            .clickable {
                                if (qrcode == false) {
                                    qrcode = true
                                }
                            })
                }else{
                    Image(
                        painter = painterResource(R.drawable.symbole_ecran_principal),
                        contentDescription = "Menu principal",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                if (qrcode == true) {
                                    qrcode = false
                                }
                            })
                }
            }
        },
        // Pass the body in
        // content parameter
        content = {
                if (qrcode == false) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    painter = planActuel,
                                    contentDescription = "Image de l'étage",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.9f)
                                )
                            }

                } else {
                    var code = EcranDeScan(controlleurNavigation)

                    if (code == "Enigme Algo") kotlin.run{
                        EcranDeScanAlgo(controlleurNavigation = controlleurNavigation, booleanEnigmeAlgo)
                    }
                    if (code == "Enigme SQL") kotlin.run{
                        EcranDeScanSQL(controlleurNavigation = controlleurNavigation, booleanEnigmeSQL)
                    }
                }
        }
    )
}

@Composable
fun MyTopAppBar(tempsDepart : Int,onNavigationIconClick: () -> Unit) {
    var tempsTotal = 40*60
    var tempsActuelle by remember { mutableStateOf(0) }
    var tempsRestant by remember {mutableStateOf("")}
    var tempsRestantInt by remember {mutableStateOf(0)}
    var minutes by remember {mutableStateOf(0)}
    var secondes by remember {mutableStateOf(0)}

    tempsActuelle = (System.currentTimeMillis() / 1000).toInt()
    tempsRestantInt = tempsTotal - (tempsActuelle - tempsDepart)
    minutes = tempsRestantInt/60
    secondes = tempsRestantInt%60
    tempsRestant = minutes.toString() + " : " + secondes.toString()


    TopAppBar(
        title = {
            Text(
                text = "Menu"
            )
            LaunchedEffect(Unit){
                    tempsActuelle = (System.currentTimeMillis() / 1000).toInt()
                    tempsRestantInt = tempsTotal - (tempsActuelle - tempsDepart)
                    minutes = tempsRestantInt/60
                    secondes = tempsRestantInt%60
                    tempsRestant = minutes.toString() + " : " + secondes.toString()
            }

            Text(
                text = tempsRestant,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onNavigationIconClick()
            }) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "navigation"
                    )
            }
        }
    )
}

@Composable
fun MyNavigationDrawer(
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    controlleurNavigation: NavController,
) {
    DrawerBody(

        items = listOf(
            MenuItem(
                id = "Inventaire",
                title = "Inventaire",
                contentDescription = "Go to home screen",
                icon = painterResource(R.drawable.symbole_inventaire),

            ),
            MenuItem(
                id = "Sauvegarde",
                title = "Sauvegarde",
                contentDescription = "Go to settings screen",
                icon = painterResource(R.drawable.symbole_sauvegarde)
            ),
        ),
        onItemClick = {
            if (it.title=="Inventaire"){
                controlleurNavigation.navigate("ecranInventaire")
            }
            println("Clicked on ${it.title}")
        }
    )
}


