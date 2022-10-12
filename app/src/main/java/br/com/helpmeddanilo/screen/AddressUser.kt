package br.com.helpmeddanilo.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

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
fun AddressUser(navController: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    //val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var enderecoUsuario by remember { mutableStateOf("") }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacaoAddressUser(navController = navController)
        },

        content = {
                contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {



            Image(
                painter = painterResource(id = R.drawable.mapssemfundo),
                contentDescription = "Logo escolha",
                modifier = Modifier.size(200.dp).padding(10.dp))

            Text(text = "Coloque seu endereço para continuar o atendimento",
                style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

            OutlinedTextField(
                value = enderecoUsuario,
                onValueChange = {enderecoUsuario = it},
                placeholder = { Text(text = "Seu endereço")},
            shape = CircleShape,
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                singleLine = true,
                maxLines = 1
            )

            Button(
                onClick = {
                    navController.navigate(Screens.ScreenMessage.route)
                          },
                modifier = Modifier.fillMaxWidth(0.7f),
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = verdoDoBotao)
            )
            {
                Text(text = "Continuar", color = Color.White)
            }
        }
        }
    )

}






@Composable
fun BarraNavegacaoAddressUser(navController: NavController){


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