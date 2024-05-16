package com.example.wazitoecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.theme.screens.home.HomeScreen

import com.example.wazitoecommerce.ui.theme.screens.login.LoginScreen
import com.example.wazitoecommerce.ui.theme.screens.products.AddProductsScreen
import com.example.wazitoecommerce.ui.theme.screens.profile.ProfileScreen
import com.example.wazitoecommerce.ui.theme.screens.rent.AddRentalDetails
import com.example.wazitoecommerce.ui.theme.screens.signup.SignupScreen
import com.example.wazitoecommerce.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(SPLASH_URL) {
            SplashScreen(navController = navController)
        }
        composable(LOGIN_URL) {
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL) {
            SignupScreen(navController = navController)
        }
        composable(HOME_URL) {
            HomeScreen(navController = navController)
        }

        composable(ADD_RENTAL_URL) {
            AddRentalDetails(navController = navController)
        }
        composable(ADD_PRODUCTS_URL) {
            AddProductsScreen(navController = navController)
        }


        composable(PROFILE_URL) {
            ProfileScreen(navController = navController)
        }

    }
}