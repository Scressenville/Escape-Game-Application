package sae.escapegame.application.android


import android.annotation.SuppressLint
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
    booleanEnigmeAlgo: Boolean, booleanEnigmeSQL: Boolean, booleanDidacticiel: Boolean, planActuel: Painter) {

    var qrcode by remember{ mutableStateOf(false) }
    val aide = remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    if (!booleanDidacticiel){
        Didacticiel(controlleurNavigation)
    }

    if(aide.value){
        Aide(aide)
    }




    BackHandler(true, onBack = {
        //do nothing
        println("Boutton retour préssé")
    })
    Scaffold(

        // pass the scaffold state
        scaffoldState = scaffoldState,

        topBar = {
            MyTopAppBar {
                // open the drawer
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },

        drawerContent = {
            MyNavigationDrawer(coroutineScope = coroutineScope, scaffoldState = scaffoldState)

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
                painter = painterResource(R.drawable.loggyavatar),
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
                Image(
                    painter = painterResource(R.drawable.symbole_qr_code),
                    contentDescription = "Qrcode",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .clickable {
                            if (qrcode == false) {
                                qrcode = true
                            }
                        })
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
fun MyTopAppBar(onNavigationIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Menu"
            )
            Text(
                text = "40:00",
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
    scaffoldState: ScaffoldState
) {
    DrawerBody(
        items = listOf(
            MenuItem(
                id = "Inventaire",
                title = "Inventaire",
                contentDescription = "Go to home screen",
                icon = painterResource(R.drawable.symbole_inventaire)
            ),
            MenuItem(
                id = "Sauvegarde",
                title = "Sauvegarde",
                contentDescription = "Go to settings screen",
                icon = painterResource(R.drawable.symbole_sauvegarde)
            ),
            MenuItem(
                id = "Aide",
                title = "Aide",
                contentDescription = "Get help",
                icon = painterResource(R.drawable.symbole_aide)
            ),
        ),
        onItemClick = {
            println("Clicked on ${it.title}")
        }
    )
}

