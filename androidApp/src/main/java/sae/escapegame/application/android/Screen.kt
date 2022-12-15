package sae.escapegame.application.android

sealed class Screen(val route: String){

    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object EnigmeOneScreen : Screen("enigme_One_screen")
    object ResolvEnigmeOneScreen : Screen("resol_enigme_one_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }
}