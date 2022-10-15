package br.com.helpmeddanilo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.helpmeddanilo.screen.*


@Composable
fun SetupNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route){

        composable(
            route = Screens.SplashScreen.route
        ){
            SplashScreen(navController = navController)
        }

        composable(
            route = Screens.Login.route
        ){
            Login(navController = navController)
        }

        composable(
            route = Screens.Welcome.route
        ){
            Welcome(navController = navController)
        }

        composable(
            route = Screens.EmergencyType.route
        ){
            EmergencyType(navController = navController)
        }

        composable(
            route = Screens.PerfilUser.route
        ){
            PerfilUser(navController = navController)
        }

        composable(
            route = Screens.TypeCall.route
        ){
            TypeCall(navController = navController)
        }

        composable(
            route = Screens.AddressUser.route
        ){
            AddressUser(navController = navController)
        }

        composable(
            route = Screens.ScreenMessage.route
        ){
            ScreenMessage(navController = navController)
        }

        composable(
            route = Screens.ServiceEvaluation.route
        ){
            ServiceEvaluation(navController = navController)
        }

    }



}