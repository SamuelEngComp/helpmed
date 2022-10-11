package br.com.helpmeddanilo.screen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun PerfilUser(navController: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    //val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    var nomeCompletoDoPaciente by remember { mutableStateOf("") }
    var numeroDoRG by remember { mutableStateOf("") }
    var numeroDoCartaoDoSUS by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BarraNavegacaoUser(navController = navController)
        },

        content = {
                contentPadding -> Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Perfil do Paciente",
                    style = MaterialTheme.typography.body1, textAlign = TextAlign.Center)
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier.padding(10.dp),
                value = nomeCompletoDoPaciente,
                onValueChange = {nomeCompletoDoPaciente = it},
                shape = CircleShape,
            placeholder = { Text(text = "Nome completo do paciente")}
            )

            OutlinedTextField(
                modifier = Modifier.padding(10.dp),
                value = numeroDoRG,
                onValueChange = {numeroDoRG = it},
                shape = CircleShape,
                placeholder = { Text(text = "Número de RG")})

            OutlinedTextField(
                modifier = Modifier.padding(10.dp),
                value = numeroDoCartaoDoSUS,
                onValueChange = {numeroDoCartaoDoSUS = it},
                shape = CircleShape,
                placeholder = { Text(text = "Número do Cartão do SUS")})

            OutlinedTextField(
                modifier = Modifier.padding(10.dp),
                value = endereco,
                onValueChange = {endereco = it},
                shape = CircleShape,
                placeholder = { Text(text = "Endereço")})

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Tipo sanguíneo",
                    style = MaterialTheme.typography.body1, textAlign = TextAlign.Center)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column() {
                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "A+", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "A-", color = Color.White)
                        }
                    }

                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "AB+", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "AB-", color = Color.White)
                        }
                    }

                }

                Column() {
                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)
                        ) {
                            Text(text = " B+ ", color = Color.White)
                        }
                        
                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "B-", color = Color.White)
                        }
                    }

                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "O+", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { /*TODO*/ },
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape)) {
                            Text(text = "O-", color = Color.White)
                        }
                    }

                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Alergias detectadas",
                    style = MaterialTheme.typography.body1, textAlign = TextAlign.Start)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalArrangement = Arrangement.Start) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Polaramine",
                        style = MaterialTheme.typography.body1)
                    Text(text = "Hidrocortisona",
                        style = MaterialTheme.typography.body1)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Doador de órgãos",
                    style = MaterialTheme.typography.body1, textAlign = TextAlign.Start)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = verdoDoBotao
                    ),
                    shape = CircleShape) {
                    Text(text = "Sim", color = Color.White)
                }

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = verdoDoBotao
                    ),
                    shape = CircleShape) {
                    Text(text = "Não", color = Color.White)
                }
            }




        }
        }
    )

}


@Composable
fun BarraNavegacaoUser(navController: NavController){


    TopAppBar(
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.Welcome.route){
                    popUpTo(Screens.Welcome.route){
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
        actions = {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(2.dp)) {
                Text(text = "Pular")
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


