package sae.escapegame.application.android


import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MenuPrincipal(enigme1 : Ecran, enigme2 : Ecran, controlleurNavigation: NavController) {
    var qrcode by remember{ mutableStateOf(false) }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
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
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(R.drawable.symbole_ecran_principal),
                    contentDescription = "MenuPrincipale",
                    modifier = Modifier
                        .height(50.dp)
                        .clickable {
                            if (qrcode == true) {
                                qrcode = false
                            }
                        })

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
                                    painter = painterResource(R.drawable.plan_rdc),
                                    contentDescription = "Image de l'étage",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.9f)
                                )
                            }

                } else {
                    EcranDeScan(
                        enigme1 = enigme1,
                        enigme2 = enigme2,
                        controlleurNavigation = controlleurNavigation
                    )
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


