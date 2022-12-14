package br.com.helpmeddanilo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.helpmeddanilo.navigation.SetupNavGraph
import br.com.helpmeddanilo.screen.EmergencyType
import br.com.helpmeddanilo.screen.Login
import br.com.helpmeddanilo.screen.Welcome
import br.com.helpmeddanilo.ui.theme.HelpMedDaniloTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            HelpMedDaniloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    navController = rememberNavController()

                    //Login()
                    //Welcome()
                    //EmergencyType()
                    
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}
