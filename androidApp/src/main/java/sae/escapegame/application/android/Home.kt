package sae.escapegame.application.android

import android.text.style.AlignmentSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Home() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)){
            Column(modifier = Modifier
                .fillMaxWidth(0.2f)
                .fillMaxHeight()
                .padding(start=0.dp,30.dp,0.dp,0.dp)
                .background(Color.LightGray),
                verticalArrangement = Arrangement.spacedBy(30.dp)){
                Image(painter = painterResource(R.drawable.sac_a_dos), contentDescription = "inventaire")

                Image(painter = painterResource(R.drawable.sauvegarde), contentDescription = "sauvegarde")

                Image(painter = painterResource(R.drawable.aide), contentDescription = "aide")

            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceAround
            )
            {
                Text(text = "40:00", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right, fontWeight = FontWeight.Bold, fontSize = 30.sp)
                Image(contentScale = ContentScale.Crop
                    ,painter = painterResource(R.drawable.plan_rdc)
                    , contentDescription = "image de l'étage"
                    , modifier = Modifier
                        .fillMaxWidth())


            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceAround)
        {
            Image(painter = painterResource(R.drawable.home), contentDescription = "inventaire")

            Image(painter = painterResource(R.drawable.qrcode_scanner), contentDescription = "sauvegarde", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxHeight())
        }
    }
}