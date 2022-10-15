package br.com.helpmeddanilo.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.helpmeddanilo.R
import br.com.helpmeddanilo.navigation.Screens
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){

    //iniciando animacao
    var iniciarAnimacao by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(iniciarAnimacao) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
            easing = LinearOutSlowInEasing
        ))



    LaunchedEffect(key1 = true){
        iniciarAnimacao = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screens.Login.route)
    }

    Splash(alpha = alphaAnim.value)
}



@Composable
fun Splash(alpha: Float){
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = painterResource(id = R.drawable.logo02semfundo),
            contentDescription = "Logo", modifier = Modifier
                .size(250.dp)
                .alpha(alpha = alpha))

        Loader(alpha = alpha)

        Text(
            text = "App em desenvolvimento",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.alpha(alpha = alpha))

    }
    
    
}




@Composable
fun Loader(alpha: Float) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.vital))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        modifier = Modifier.size(150.dp).alpha(alpha = alpha),
        composition = composition,
        progress = { progress },
    )
}