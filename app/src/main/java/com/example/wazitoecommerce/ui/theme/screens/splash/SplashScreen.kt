package com.example.wazitoecommerce.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.ui.theme.Orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController){
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val coroutine = rememberCoroutineScope()
        coroutine.launch {
            delay(1950)
            navController.navigate(LOGIN_URL)
        }
        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.sp))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.fillMaxSize()
        )
        //End of lottie animation
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController = rememberNavController())
}