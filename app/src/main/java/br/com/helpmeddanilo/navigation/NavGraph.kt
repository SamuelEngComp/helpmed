package br.com.helpmeddanilo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.helpmeddanilo.screen.EmergencyType
import br.com.helpmeddanilo.screen.Login
import br.com.helpmeddanilo.screen.PerfilUser
import br.com.helpmeddanilo.screen.Welcome


@Composable
fun SetupNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route){

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

    }



}