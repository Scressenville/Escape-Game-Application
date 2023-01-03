package sae.escapegame.application.android.QCM

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun skillTest(navController: NavController, item: Array<String>){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),

        ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .padding(15.dp, 50.dp)
        ) {
            Column(modifier = Modifier
                .padding(30.dp)){
                Text("Test de connaissances : ")
                Text("Selectionne la/les reponse.s juste.s ! ")
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = item[0])
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = item[1])
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = item[2])
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = item[3])
                }

            }
        }
    }
}




