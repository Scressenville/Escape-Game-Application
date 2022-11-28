package sae.escapegame.application

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform