package br.com.helpmeddanilo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.corDoIcone
import br.com.helpmeddanilo.ui.theme.verdoDoBotao


@Composable
fun Welcome(navController: NavController){
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        
        Image(
            painter = painterResource(id = R.drawable.medicasemfundo),
            contentDescription = "Logo de boas vindas")

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Bem-Vindo",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Escolha aqui qual o tipo de atendimento que você necessita",
            style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            Button(
                onClick = {
                          navController.navigate(route = Screens.PerfilUser.route)
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

                    Icon(imageVector = Icons.Default.Person, contentDescription = "Icone de perfil", tint = corDoIcone)
                    Text(text = "Perfil", color = Color.White)
                }
            }

            Button(
                onClick = {
                    navController.navigate(Screens.EmergencyType.route)
                    /*{
                        popUpTo(Screens.EmergencyType.route){
                            inclusive = true
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

                    Icon(imageVector = Icons.Default.Call, contentDescription = "Icone de telefone", tint = corDoIcone)
                    Text(text = "Atendimento", color = Color.White)
                }
            }
        }


        
    }

}