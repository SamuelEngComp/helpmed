package br.com.helpmeddanilo.navigation

sealed class Screens(val route: String){

    object Login: Screens("login_screen")
    object Welcome: Screens("welcome_screen")
    object EmergencyType: Screens("emergency_type_screen")
    object PerfilUser: Screens("perfil_user_screen")

}
