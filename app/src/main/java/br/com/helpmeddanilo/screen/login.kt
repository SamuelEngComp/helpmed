package br.com.helpmeddanilo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import br.com.helpmeddanilo.ui.theme.corDaBordaDosCamposLogin
import br.com.helpmeddanilo.ui.theme.verdoDoBotao


@Composable
fun Login(navController: NavController){

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }



    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo02semfundo),
            contentDescription = "Logotipo",
        modifier = Modifier.size(250.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {Text(text = "E-mail ou nome de usuário")}
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = {senha = it},
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = {Text(text = "Senha")}
        )
        
        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = verdoDoBotao
            ),
            shape = RoundedCornerShape(20.dp)
        ){
            Text(text = "Acessar", color = Color.White)
        }
        
        Text(text = "Continue se não possuir cadastro")

        OutlinedButton(
            onClick = {
                      navController.navigate(route = Screens.Welcome.route)
                      },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, color = verdoDoBotao)
        ){
            Text(text = "Continue",
                color = if (isSystemInDarkTheme()){
                            Color.White
                        }else{
                            Color.Black
                        }
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            Text(text = "Não possui conta?",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp))

            TextButton(
                onClick = { /*TODO*/ },
                shape = CircleShape
            ) {
                Text(text = "Criar Conta",
                    color = verdoDoBotao,
                style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(10.dp))
            }
        }
        

    }


}