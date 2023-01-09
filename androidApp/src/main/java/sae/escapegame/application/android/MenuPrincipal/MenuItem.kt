package sae.escapegame.application.android.MenuPrincipal

import androidx.compose.ui.graphics.painter.Painter

data class MenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: Painter
)