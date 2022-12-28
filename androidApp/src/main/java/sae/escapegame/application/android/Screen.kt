package sae.escapegame.application.android

sealed class Screen(val route: String){

    object MainScreen : Screen("main_screen")

    object Cinematic1Screen : Screen("cinematic1_screen")
    object ChoixEnigme1 : Screen("choix_enigme")
    object Cinematic2Screen : Screen("cinematic2_screen")
    object Cinematic3Screen : Screen("cinematic3_screen")

    object DetailScreen : Screen("detail_screen")
    object EnigmeOneScreen : Screen("enigme_One_screen")
    object ResolvEnigmeOneScreen : Screen("resol_enigme_one_screen")

    object HomeScreen : Screen("home_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}