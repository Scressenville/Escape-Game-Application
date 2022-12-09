package sae.escapegame.application.android

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    // create a scaffold state, set it to close by default
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    // Create a coroutine scope. Opening of
    // Drawer and snackbar should happen in
    // background thread without blocking main thread
    val coroutineScope = rememberCoroutineScope()

    // Scaffold Composable
    Scaffold(

        // pass the scaffold state
        scaffoldState = scaffoldState,

        // pass the topbar we created
        topBar = {
            TopBar(
                // When menu is clicked open the
                // drawer in coroutine scope
                onMenuClicked = {
                    coroutineScope.launch {
                        // to close use -> scaffoldState.drawerState.close()
                        scaffoldState.drawerState.open()
                    }
                })
        },

        // pass the bottomBar
        // we created
        bottomBar = { BottomBar() },

        // Pass the body in
        // content parameter
        content = {
            body(navController)
        },

        // pass the drawer
        drawerContent = {
            Drawer()
        },

        floatingActionButton = {
            // Create a floating action button in
            // floatingActionButton parameter of scaffold
            FloatingActionButton(

                onClick = {
                    // When clicked open Snackbar
                    coroutineScope.launch {
                        when (scaffoldState.snackbarHostState.showSnackbar(
                            // Message In the snackbar
                            message = "Snack Bar",
                            actionLabel = "Dismiss"
                        )) {
                            SnackbarResult.Dismissed -> {
                                // do something when
                                // snack bar is dismissed
                            }

                            SnackbarResult.ActionPerformed -> {
                                // when it appears
                            }
                        }
                    }
                }) {
                // Simple Text inside FAB
                Text(text = "X")
            }
        }
    )
}

@Composable
private fun body(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.route)
            },
        ) {
            Text(stringResource(sae.escapegame.application.android.R.string.btnJouer))
        }


    }
}

@Composable
fun Drawer() {
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        // Repeat is a loop which
        // takes count as argument
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}
@Composable
fun BottomBar() {
    // BottomAppBar Composable
    BottomAppBar(
        backgroundColor = Color(0xFF9C51B5)
    ) {
        Text(text = " ", color = Color.White)
    }
}

// A function which will receive a
// callback to trigger to opening the drawer
@Composable
fun TopBar(onMenuClicked: () -> Unit) {

    // TopAppBar Composable
    TopAppBar(
        // Provide Title
        title = {
            Text(text = "Help Loggy", color = Color.White)
        },
        // Provide the navigation Icon (Icon on the left to toggle drawer)
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.White
            )
        },
        // background color of topAppBar
        backgroundColor = Color(0xFF9C51B5)
    )
}
