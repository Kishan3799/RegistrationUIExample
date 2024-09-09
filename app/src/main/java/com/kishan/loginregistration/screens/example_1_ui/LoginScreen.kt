package com.kishan.loginregistration.screens.example_1_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.loginregistration.R
import com.kishan.loginregistration.component.CustomButton
import com.kishan.loginregistration.component.CustomCheckBox
import com.kishan.loginregistration.component.CustomClickableText
import com.kishan.loginregistration.component.CustomIconButton
import com.kishan.loginregistration.component.CustomPasswordField
import com.kishan.loginregistration.component.CustomTextField
import com.kishan.loginregistration.component.HeadingTextComponent
import com.kishan.loginregistration.component.SmallTextComponent
import com.kishan.loginregistration.navigation.Router


@Composable
fun LoginScreen(navController: NavController) {
    val textValue = remember {
        mutableStateOf("")
    }
    val passwordValue = remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            HeadingTextComponent(text = stringResource(id = R.string.sign_in))
            Spacer(modifier = Modifier.height(18.dp))
            CustomTextField(textValue = textValue.value, onTextValueChange = {
                textValue.value = it
            }, labelValue = "Your Email Address")
            CustomPasswordField(
                textValue = passwordValue.value,
                onTextValueChange = { passwordValue.value = it },
                labelValue = "Password",
            )
            CustomCheckBox(value = "Remember Me", onClick = {})
            CustomButton(onButtonClick = {}, buttonText = stringResource(id = R.string.sign_up_button_text))
            Spacer(modifier = Modifier.height(24.dp))
            SmallTextComponent(text = "or Sign in With", sizeOfText = 16.sp)
            Spacer(modifier = Modifier.height(18.dp))
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally)
            ){
                CustomIconButton(onButtonClick = {}, icon = painterResource(id = R.drawable.google_icon))
                CustomIconButton(onButtonClick = {}, icon = painterResource(id = R.drawable.facebook_icon))
            }
            Spacer(modifier = Modifier.height(100.dp))
            CustomClickableText(tryToLogin = false,onTextSelected = {
                navController.navigate(Router.RegisterRoute.route){
                    popUpTo(Router.LoginRoute.route){
                        inclusive = true
                    }
                }
            })
        }
    }
}

@Preview
@Composable
private fun DefaultLoginPreview() {
    LoginScreen(navController = rememberNavController())
}