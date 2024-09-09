package com.kishan.loginregistration.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.kishan.loginregistration.navigation.Router

import com.kishan.loginregistration.screens.example_1_ui.LoginScreen
import com.kishan.loginregistration.screens.MainScreen
import com.kishan.loginregistration.screens.example_1_ui.RegistrationScreen
import com.kishan.loginregistration.screens.example_2_ui.LoginScreen2
import com.kishan.loginregistration.screens.example_2_ui.RegisterScreen2
import com.kishan.loginregistration.screens.example_2_ui.VerifyOtpScreen
import com.kishan.loginregistration.screens.example_3_ui.LoginScreen3
import com.kishan.loginregistration.screens.example_3_ui.OtpScreen3
import com.kishan.loginregistration.screens.example_3_ui.SignupScreen3

@Composable
fun ExampleApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Router.MainRoute.route){
        composable(Router.MainRoute.route){ MainScreen(navController = navController)}

        composable(Router.LoginRoute.route){ LoginScreen(navController = navController) }
        composable(Router.RegisterRoute.route){ RegistrationScreen(navController = navController) }

        composable(Router.LoginRoute2.route){ LoginScreen2(navController = navController) }
        composable(Router.RegisterRoute2.route){ RegisterScreen2(navController = navController) }
        composable(Router.VerifyRoute2.route){ VerifyOtpScreen(navController = navController) }

        composable(Router.LoginRoute3.route){ LoginScreen3(navController = navController)}
        composable(Router.RegisterRoute3.route){ SignupScreen3(navController = navController) }
        composable(Router.VerifyRoute3.route){ OtpScreen3(navController = navController) }


    }
}