package sae.escapegame.application.android

sealed class Screen(val route: String){

    object MainScreen : Screen("main_screen")
    object Cinematic1Screen : Screen("cinematic1_screen")
    object ChoixEnigme1 : Screen("choix_enigme")
    object Cinematic2Screen : Screen("cinematic2_screen")
    object Cinematic3Screen : Screen("cinematic3_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}