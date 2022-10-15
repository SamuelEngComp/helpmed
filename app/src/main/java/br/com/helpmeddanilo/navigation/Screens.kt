package br.com.helpmeddanilo.navigation

sealed class Screens(val route: String){

    object SplashScreen: Screens("splash_screen")
    object Login: Screens("login_screen")
    object Welcome: Screens("welcome_screen")
    object EmergencyType: Screens("emergency_type_screen")
    object PerfilUser: Screens("perfil_user_screen")
    object TypeCall: Screens("type_call_screen")
    object AddressUser: Screens("address_user_screen")
    object ScreenMessage: Screens("screen_message_screen")
    object ServiceEvaluation: Screens("service_evaluation_screen")


}
