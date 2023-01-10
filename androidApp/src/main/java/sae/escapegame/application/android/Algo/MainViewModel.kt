package sae.escapegame.application.android.Algo

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<WordUiItem>())
        private set

    var addedWord = mutableStateListOf<WordUiItem>()
        private set

    init {
        items = listOf(
            WordUiItem("print","1", Color(223,98,98)),
            WordUiItem("input","2", Color(197, 79, 137, 255)),
            WordUiItem("str","3", Color(98,207,223)),
            WordUiItem("NomJoueur","3", Color(237,246,109))
        )
    }

    fun startDragging(){
        isCurrentlyDragging = true
    }
    fun stopDragging(){
        isCurrentlyDragging = false
    }

    fun addWord(wordUiItem: WordUiItem){
        addedWord.add(wordUiItem)
    }

}