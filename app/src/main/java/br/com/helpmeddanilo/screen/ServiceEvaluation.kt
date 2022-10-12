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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.verdoDoBotao


@Composable
fun ServiceEvaluation(navController: NavController){


    val scaffoldState: ScaffoldState = rememberScaffoldState()

    var cliqueBotao by remember{ mutableStateOf(0) }

    val openDialog = remember { mutableStateOf(false)  }
    var abrirAlert by remember{ mutableStateOf( false) }



    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacaoServiceEvaluation(navController = navController)
        },

        content = {
                contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {

            Row(modifier = Modifier.padding(20.dp)) {
                Text(text = "Avalie o atendimento",
                    style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
            }



            Row() {

                Column(verticalArrangement = Arrangement.SpaceAround) {

                    Button(
                        onClick = {
                            abrirAlert = !abrirAlert
                        },
                        modifier = Modifier.fillMaxWidth(0.7f),
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = verdoDoBotao)
                    )
                    {
                        Text(text = "Muito bom", color = Color.White)
                    }

                    Button(
                        onClick = {
                            abrirAlert = !abrirAlert
                        },
                        modifier = Modifier.fillMaxWidth(0.7f),
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = verdoDoBotao)
                    )
                    {
                        Text(text = "Bom", color = Color.White)
                    }

                    Button(
                        onClick = {
                            abrirAlert = !abrirAlert
                        },
                        modifier = Modifier.fillMaxWidth(0.7f),
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = verdoDoBotao)
                    )
                    {
                        Text(text = "Regular", color = Color.White)
                    }

                    Button(
                        onClick = {
                            abrirAlert = !abrirAlert
                        },
                        modifier = Modifier.fillMaxWidth(0.7f),
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = verdoDoBotao
                        )
                    )
                    {
                        Text(text = "Ruim", color = Color.White)
                    }

                    Button(
                        onClick = {
                            abrirAlert = !abrirAlert
                        },
                        modifier = Modifier.fillMaxWidth(0.7f),
                        shape = CircleShape,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = verdoDoBotao)
                    )
                    {
                        Text(text = "Muito ruim", color = Color.White)
                    }
                }

            }


            Row(modifier = Modifier.padding(10.dp)) {
                OutlinedButton(
                    onClick = {
                        navController.navigate(route = Screens.Welcome.route)
                    },
                    modifier = Modifier.fillMaxWidth(0.7f),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, color = verdoDoBotao)
                ){
                    Text(text = "Pular avaliação",
                        color = if (isSystemInDarkTheme()){
                            Color.White
                        }else{
                            Color.Black
                        }
                    )
                }
            }



            if (abrirAlert){
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = { Image(painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                        contentDescription = "icone curtir",
                        modifier = Modifier.size(60.dp),
                        alignment = Alignment.Center)},
                    text = {Text(text = "Muito obrigado por sua avaliação")},
                    confirmButton = {
                        /*Button(onClick = { openDialog.value = false }) {
                            Text(text = "Ok")
                        }*/
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                openDialog.value = true
                                navController.navigate(Screens.Login.route)
                            }) {
                            Text(text = "ok")
                        }
                    }
                )
            }

        }
        }
    )






}




@Composable
fun BarraNavegacaoServiceEvaluation(navController: NavController){


    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.TypeCall.route){
                    popUpTo(Screens.TypeCall.route){
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