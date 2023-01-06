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

    var suivant by remember{ mutableStateOf(0) }
    var compteur1 : Int by remember{mutableStateOf(0)}
    var compteur2 : Int by remember{mutableStateOf(0)}
    var compteur3 : Int by remember{mutableStateOf(0)}

    var enigmesTitre : Array<String>
    enigmesTitre = stringArrayResource(id = R.array.enigmesSQL)
    var listes_phrases : Array<String>
    listes_phrases = stringArrayResource(id = R.array.phrasesacompléter)
    var choix_réponses : Array<String> by remember{ mutableStateMapOf() }
    choix_réponses = stringArrayResource(id = R.array.réponses)[suivant].split(",").toTypedArray()
    var phrase_a_compléter : String by remember{ mutableStateOf("") }
    var reponse_juste : Array<String>
    reponse_juste = stringArrayResource(id = R.array.reponses_juste)[suivant].split(",").toTypedArray()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.symbole_qr_code), contentDescription = null)
        //Titre de la question
       Text(text = enigmesTitre[suivant])
        //Phrase a compléter
        phrase_a_compléter = listes_phrases[suivant]
        phrase_a_compléter = phrase_a_compléter.replace("1",choix_réponses[compteur1])
        phrase_a_compléter = phrase_a_compléter.replace("2",choix_réponses[compteur2])
        phrase_a_compléter = phrase_a_compléter.replace("3",choix_réponses[compteur3])
        Text(text = phrase_a_compléter)

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
        Row(){

            Button(onClick = {
                var verif = true
                for (i in 0..choix_réponses.size-1){
                    if (choix_réponses[i] != reponse_juste[i]){
                        verif=false
                    }
            }
                if (suivant < enigmesTitre.size - 1 && verif == true){
                    suivant += 1
                }
            }){
                Text("Suivant")
            }
        }
    }
}

