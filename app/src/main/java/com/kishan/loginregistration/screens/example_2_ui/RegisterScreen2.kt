package com.kishan.loginregistration.screens.example_2_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kishan.loginregistration.R
import com.kishan.loginregistration.navigation.Router
import com.kishan.loginregistration.screens.example_2_ui.component.CheckBoxWithText
import com.kishan.loginregistration.screens.example_2_ui.component.CustomClickableText2
import com.kishan.loginregistration.screens.example_2_ui.component.CustomUserButton
import com.kishan.loginregistration.screens.example_2_ui.component.DividerWithTextComponent
import com.kishan.loginregistration.screens.example_2_ui.component.HeaderTextWithIcon
import com.kishan.loginregistration.screens.example_2_ui.component.IconButtonComponent
import com.kishan.loginregistration.screens.example_2_ui.component.PasswordFieldWithLabel
import com.kishan.loginregistration.screens.example_2_ui.component.SubHeadingText
import com.kishan.loginregistration.screens.example_2_ui.component.TextFieldWithLabel

@Composable
fun RegisterScreen2(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    listOf(Color(0xFFFFFFFF), Color(0xFF6F68FF)),
                    radius = 100000.0f / 30.0f
                )
            )
            .padding(16.dp)
    ){
        Box(modifier = Modifier.height(60.dp)) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "Back to Screen",modifier = Modifier.padding(0.dp))
            }
        }
        HeaderTextWithIcon(value = "Create an account", icon = painterResource(id =R.drawable.start_icon))
        Spacer(modifier = Modifier.height(8.dp))
        SubHeadingText(value = "Welcome! Please enter your details")
        Spacer(modifier = Modifier.height(16.dp))
        TextFieldWithLabel(
            label = "Name",
            icon = Icons.Outlined.Person,
            placeHolder = "Enter your name"
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextFieldWithLabel(
            label = "Email",
            icon = Icons.Outlined.Mail,
            placeHolder = "Enter your email"
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordFieldWithLabel(
            label = "Password",
            placeHolder = "Enter your password",
            icon = Icons.Outlined.Lock
        )
        Spacer(modifier = Modifier.height(12.dp))
        CheckBoxWithText(text = "Must be at least 8 characters")
        Spacer(modifier = Modifier.height(24.dp))
        CustomUserButton(value = "Sign Up") {
            navController.navigate(Router.VerifyRoute2.route)
        }
        Spacer(modifier = Modifier.height(12.dp))
        DividerWithTextComponent(text = "Or sign up with")
        Spacer(modifier = Modifier.height(18.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterHorizontally)){
            IconButtonComponent(icon = painterResource(id = R.drawable.apple_logo_svgrepo_com))
            IconButtonComponent(icon = painterResource(id = R.drawable.google_icon_logo_svgrepo_com))
            IconButtonComponent(icon = painterResource(id = R.drawable.facebook_3_logo_svgrepo_com))
        }
        Spacer(modifier = Modifier.height(150.dp))
        CustomClickableText2 {
            navController.navigate(Router.LoginRoute2.route){
                popUpTo(Router.RegisterRoute2.route){
                    inclusive = true
                }
            }
        }
    }
}





