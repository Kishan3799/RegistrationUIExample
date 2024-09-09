package com.kishan.loginregistration.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.loginregistration.component.CustomButton
import com.kishan.loginregistration.navigation.Router

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "SignIn And SignUp Ui",
                        style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                        ),
                    )
                },
                colors = TopAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    scrolledContainerColor = Color.Unspecified
                )
            )
        }
    ){ innerPadding->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            CustomButton(onButtonClick = {
                navController.navigate(Router.LoginRoute.route)
            }, buttonText = "Example one")
            CustomButton(
                onButtonClick = { navController.navigate(Router.LoginRoute2.route) },
                buttonText = "Example two"
            )
            CustomButton(onButtonClick = { navController.navigate(Router.LoginRoute3.route) }, buttonText = "Example Three")
        }
    }
}

@Preview
@Composable
private fun DefaultMainScreenPreview() {
    MainScreen(navController = rememberNavController())
}