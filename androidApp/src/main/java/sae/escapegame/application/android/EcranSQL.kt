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
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SQL(){
    var question = stringArrayResource(id = R.array.questionsSQL)
    var suivant : Int by remember{mutableStateOf(0)}
    var listeMots : Array<String>
    listeMots = stringArrayResource(id = R.array.questionsSQL)
    var compteur1 : Int by remember{mutableStateOf(0)}
    var compteur2 : Int by remember{mutableStateOf(0)}
    var compteur3 : Int by remember{mutableStateOf(0)}
    var mots by remember {
        mutableStateOf(listeMots[suivant].split(","))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.symbole_qr_code), contentDescription = null)

       Text(text = question[suivant], fontSize = 30.sp)

       Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
           mots = listeMots[suivant].split(",")
          Text(
              "Select " + mots[compteur1] + "\nFrom " + mots[compteur2] + "Join Etudiant On Etudiant.idEtudiant = " +  mots[compteur2] + ".idEtudiant \n"
          +"Where " + mots[compteur1] +"= "+ mots[compteur3], fontSize = 20.sp
          )
       }
        Column(){
            Button(onClick = {
                if (compteur1 < 2) {
                    compteur1 += 1
                }
                else{
                    compteur1 = 0
                }
            }){Text("premier mot : " + compteur1)}
            Button(onClick = {
                if (compteur2 < 2) {
                    compteur2 += 1
                }
                else{
                    compteur2 = 0
                }
            }){Text("deuxieme mot : " + compteur2)}
            Button(onClick = {
                if (compteur3 < 2) {
                    compteur3 += 1
                }
                else{
                    compteur3 = 0
                }
            }){Text("troisieme mot : " + compteur3)}
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End ){
            Button(onClick = {
                if (suivant < question.size - 1){
                    suivant += 1

            } }) {
                Text("Suivant")
            }
        }
    }
}

