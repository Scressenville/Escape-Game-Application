package sae.escapegame.application.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SQL(){
    var réponse by remember { mutableStateOf(0) }
    var codes : Array<String>
    codes = stringArrayResource(id = R.array.codesSql)
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.symbole_qr_code), contentDescription = null)

       Text(text = stringResource(id = R.string.questionSQL))

        Row(modifier = Modifier.fillMaxWidth().height(100.dp), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { réponse = 1 }, modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight()) {
                Text(text = codes[0])
            }
            Button(onClick = { réponse = 2 }, modifier = Modifier.fillMaxWidth(0.6f).fillMaxHeight()) {
                Text(text = codes[1])
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { réponse = 3 }, modifier = Modifier.fillMaxWidth(0.4f)) {
                Text(text = codes[2])
            }
            Button(onClick = { réponse = 4 }, modifier = Modifier.fillMaxWidth(0.7f)) {
                Text(text = codes[3])
            }
        }
    }
}