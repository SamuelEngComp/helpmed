package br.com.helpmeddanilo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
            horizontalAlignment = Alignment.CenterHorizontally) {


            Text(text = "Avalie o atendimento",
                style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

            Button(
                onClick = {
                    abrirAlert = !abrirAlert
                },
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
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = verdoDoBotao)
            )
            {
                Text(text = "Muito ruim", color = Color.White)
            }

            OutlinedButton(
                onClick = {
                    navController.navigate(route = Screens.Welcome.route)
                },
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

            if (abrirAlert){
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = { Text(text = "Seu atendimento esta sendo encaminhado")},
                    text = {Text(text = "Seu atendimento esta sendo encaminhado")},
                    confirmButton = {
                        Button(onClick = { openDialog.value = false }) {
                            Text(text = "Ok")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                openDialog.value = true
                                navController.navigate(Screens.Login.route)
                            }) {
                            Text(text = "No")
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