package br.com.helpmeddanilo.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack


import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens

import br.com.helpmeddanilo.ui.theme.verdoDoBotao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun EmergencyType(navController: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacao(navController = navController)
                 },

        content = {
            contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Image(
                painter = painterResource(id = R.drawable.escolhasemfundo),
                contentDescription = "Logo escolha")

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Escolha o tipo de emergência que necessita",
                style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))


            Button(
                onClick = {
                    coroutineScope.launch {

                        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                              message = "Ainda em desenvolvimento",
                              actionLabel = "fechar"
                          )

                        when(snackBarResult){
                            SnackbarResult.Dismissed -> Log.d("Snack", "Dismissed")
                            SnackbarResult.ActionPerformed -> Log.d("Snack", "ActionPerformed")
                        }

                    }
                },
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = verdoDoBotao
                )
            ) {
                Column(modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){

                    Text(text = "Chamada emergencial", color = Color.White)
                }
            }

            Button(
                onClick = {
                    coroutineScope.launch {

                        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Ainda em desenvolvimento",
                            actionLabel = "fechar"
                        )

                        when(snackBarResult){
                            SnackbarResult.Dismissed -> Log.d("Snack", "Dismissed")
                            SnackbarResult.ActionPerformed -> Log.d("Snack", "ActionPerformed")
                        }

                    }
                },
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = verdoDoBotao
                )
            ) {

                Column(modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

                    Text(text = "Chamada de especialista", color = Color.White)
                }
            }
        }
        }
    )

}


@Composable
fun BarraNavegacao(navController: NavController){


    TopAppBar(
        title = { Text(text = "")},
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.Welcome.route){
                    popUpTo(Screens.Welcome.route){
                        inclusive = true
                    }
                }
            })
            {
                    Icon(Icons.Default.ArrowBack,
                    contentDescription = "Icone de voltar")
            }
        },
        backgroundColor = if (isSystemInDarkTheme()){
            MaterialTheme.colors.background
        }else{
            MaterialTheme.colors.background
        },
        elevation = 0.dp
    )
}


