package br.com.helpmeddanilo.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.corDaBordaDosCamposLogin
import br.com.helpmeddanilo.ui.theme.verdoDoBotao


@Composable
fun PerfilUser(navController: NavController){

    //chip
    //val textChipRememberOneState = remember { mutableStateOf(false) }

    var tipoSanguineo by remember { mutableStateOf("") }
    var doadorSangue by remember { mutableStateOf("") }

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
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = nomeCompletoDoPaciente,
                onValueChange = {nomeCompletoDoPaciente = it},
                shape = CircleShape,
            placeholder = { Text(text = "Nome completo do paciente")},
                singleLine = true,
                maxLines = 1
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = numeroDoRG,
                onValueChange = {numeroDoRG = it},
                shape = CircleShape,
                placeholder = { Text(text = "Número de RG")},
                singleLine = true,
                maxLines = 1)

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = numeroDoCartaoDoSUS,
                onValueChange = {numeroDoCartaoDoSUS = it},
                shape = CircleShape,
                placeholder = { Text(text = "Número do Cartão do SUS")},
                singleLine = true,
                maxLines = 1)

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                value = endereco,
                onValueChange = {endereco = it},
                shape = CircleShape,
                placeholder = { Text(text = "Endereço")},
                singleLine = true,
                maxLines = 1)

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
                        IconButton(
                            onClick = {
                                tipoSanguineo = "A+"
                                      },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "A+") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {

                            Text(
                                text = "A+",
                                color = Color.White
                            )
                        }

                        /*TextChip(
                            modifier = Modifier.background(verdoDoBotao, shape = CircleShape),
                            isSelected = textChipRememberOneState.value,
                            text = "A+",
                            onChecked = {textChipRememberOneState.value = it}
                        )*/

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { tipoSanguineo = "A-" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "A-") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
                            Text(text = "A-", color = Color.White)
                        }
                    }

                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(onClick = { tipoSanguineo = "AB+" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "AB+") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
                            Text(text = "AB+", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { tipoSanguineo = "AB-" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "AB-") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
                            Text(text = "AB-", color = Color.White)
                        }
                    }

                }

                Column() {
                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(
                            onClick = { tipoSanguineo = "B+" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "B+") Color.Black else verdoDoBotao,
                                    shape = CircleShape)
                        ) {
                            Text(text = " B+ ", color = Color.White)
                        }
                        
                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { tipoSanguineo = "B-" },
                            modifier = Modifier
                                .background(if(tipoSanguineo == "B-") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
                            Text(text = "B-", color = Color.White)
                        }
                    }

                    Row(modifier = Modifier.padding(8.dp)) {
                        IconButton(onClick = { tipoSanguineo = "O+" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "O+") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
                            Text(text = "O+", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(onClick = { tipoSanguineo = "O-" },
                            modifier = Modifier
                                .background(
                                    if(tipoSanguineo == "O-") Color.Black else verdoDoBotao,
                                    shape = CircleShape)) {
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
                    onClick = { doadorSangue = "Sim" },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = if (doadorSangue == "Sim") Color.Black else verdoDoBotao
                    ),
                    shape = CircleShape){
                    Text(text = "Sim", color = Color.White)
                }

                Button(
                    onClick = { doadorSangue = "Não" },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = if (doadorSangue == "Não") Color.Black else verdoDoBotao
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
            IconButton(onClick = {
                                 navController.navigate(Screens.TypeCall.route)
            }, modifier = Modifier.padding(2.dp)) {
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

/**
 * CHIP FUNCIONANDO
 */
/*

@Composable
fun TextChip(
    modifier: Modifier,
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 2.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else LightGray,
                shape = CircleShape //MaterialTheme.shapes.medium
            )
            .background(
                color = if (isSelected) selectedColor else verdoDoBotao,//Transparent,
                shape = CircleShape //MaterialTheme.shapes.medium
            )
            .clip(shape = CircleShape) //MaterialTheme.shapes.medium
            .clickable {
                onChecked(!isSelected)
            }
            .padding(4.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) corDaBordaDosCamposLogin else White,//Unspecified,
            modifier = Modifier.padding(10.dp)
        )
    }
}
*/

