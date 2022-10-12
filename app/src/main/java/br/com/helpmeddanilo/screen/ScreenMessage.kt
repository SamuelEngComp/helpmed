package br.com.helpmeddanilo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.verdoDoBotao

@Composable
fun ScreenMessage(navController: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    //val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var enderecoUsuario by remember { mutableStateOf("") }
    var cliqueCard by remember{ mutableStateOf(0) }

    val openDialog = remember { mutableStateOf(false)  }
    var abrirAlert by remember{ mutableStateOf( false) }



    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacaoMessage(navController = navController)
        },

        content = {
                contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {


            Text(text = "Chamada por mensagem de texto",
                style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

            Card(
                modifier = Modifier
                    .padding(40.dp)
                    .clickable {
                        cliqueCard = 1
                    },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 2.dp, color = verdoDoBotao),
                backgroundColor = if (cliqueCard == 1){
                    verdoDoBotao
                }else{
                    Color.White
                }
            ) {
                Text(text = "Bom dia, preciso de atendimento",
                    modifier = Modifier.padding(30.dp), color = Color.Black)
            }

            Card(
                modifier = Modifier
                    .padding(40.dp)
                    .clickable {
                        cliqueCard = 2
                    },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 2.dp, color = verdoDoBotao),
                backgroundColor = if (cliqueCard == 2){
                    verdoDoBotao
                }else{
                    Color.White
                }
            ) {

                Text(text = "Boa tarde, preciso de atendimento",
                    modifier = Modifier.padding(30.dp), color = Color.Black)

            }

            Card(
                modifier = Modifier
                    .padding(40.dp)
                    .clickable {
                        cliqueCard = 3
                    },
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 2.dp, color = verdoDoBotao),
                backgroundColor = if (cliqueCard == 3){
                    verdoDoBotao
                }else{
                    Color.White
                }
            ) {

                Text(text = "Boa noite, preciso de atendimento",
                    modifier = Modifier.padding(30.dp), color = Color.Black)

            }

            Button(
                onClick = {
                    abrirAlert = !abrirAlert
                },
                modifier = Modifier.fillMaxWidth(0.7f),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = verdoDoBotao
                ),
                enabled = if (cliqueCard != 0) true
            else
                false
            )
            {
                Text(text = "Enviar", color = Color.White)
            }

            if (abrirAlert){
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = {
                        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                                contentDescription = "icone like",
                                modifier = Modifier
                                    .size(60.dp)
                                    .fillMaxWidth(),
                                alignment = Alignment.Center
                            )
                        }

                            },
                    text = {Text(text = "Seu atendimento esta sendo encaminhado")},
                    confirmButton = {
                        /*Button(
                            onClick = {
                                openDialog.value = false
                                navController.navigate(Screens.ServiceEvaluation.route)
                            }) {
                            Text(text = "Ok")
                        }*/
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                openDialog.value = true
                                navController.navigate(Screens.ServiceEvaluation.route)
                            }) {
                            Text(text = "Ok")
                        }
                    }
                )
            }

        }
        }
    )
}


@Composable
fun BarraNavegacaoMessage(navController: NavController){


    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.AddressUser.route){
                    popUpTo(Screens.AddressUser.route){
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
