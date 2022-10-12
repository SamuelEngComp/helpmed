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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.verdoDoBotao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun TypeCall(navController: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacaoType(navController = navController)
        },

        content = {
                contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Image(
                painter = painterResource(id = R.drawable.atendimentosemfundo),
                contentDescription = "Logo escolha",
                modifier = Modifier.size(210.dp))

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Você gostaria que seu atendimento seja",
                style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))


            Button(
                onClick = {

                          navController.navigate(Screens.AddressUser.route)


                    /*coroutineScope.launch {

                        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Ainda em desenvolvimento",
                            actionLabel = "fechar"
                        )

                        when(snackBarResult){
                            SnackbarResult.Dismissed -> Log.d("Snack", "Dismissed")
                            SnackbarResult.ActionPerformed -> Log.d("Snack", "ActionPerformed")
                        }

                    }*/
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

                    Text(text = "Chamada via áudio", color = Color.White)
                }
            }

            Button(
                onClick = {

                    navController.navigate(Screens.AddressUser.route)
                    /*coroutineScope.launch {

                        val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Ainda em desenvolvimento",
                            actionLabel = "fechar"
                        )

                        when(snackBarResult){
                            SnackbarResult.Dismissed -> Log.d("Snack", "Dismissed")
                            SnackbarResult.ActionPerformed -> Log.d("Snack", "ActionPerformed")
                        }

                    }*/
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

                    Text(text = "Chamada via texto", color = Color.White)
                }
            }
        }
        }
    )

}


@Composable
fun BarraNavegacaoType(navController: NavController){


    TopAppBar(
        title = { Text(text = "")},
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.EmergencyType.route){
                    popUpTo(Screens.EmergencyType.route){
                        inclusive = true
                    }
                }
            })
            {
                Icon(
                    Icons.Default.ArrowBack,
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