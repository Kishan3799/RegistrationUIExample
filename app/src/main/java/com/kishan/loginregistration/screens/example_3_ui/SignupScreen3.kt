package com.kishan.loginregistration.screens.example_3_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.loginregistration.R
import com.kishan.loginregistration.navigation.Router
import com.kishan.loginregistration.screens.example_3_ui.component.CheckBoxWithText
import com.kishan.loginregistration.screens.example_3_ui.component.CustomClickableText3
import com.kishan.loginregistration.screens.example_3_ui.component.CustomHeaderDraw
import com.kishan.loginregistration.screens.example_3_ui.component.GradientButton
import com.kishan.loginregistration.screens.example_3_ui.component.HeaderTextWithIcon
import com.kishan.loginregistration.screens.example_3_ui.component.IconWithTextButton
import com.kishan.loginregistration.screens.example_3_ui.component.PasswordFieldWithLabel
import com.kishan.loginregistration.screens.example_3_ui.component.SubHeadingText
import com.kishan.loginregistration.screens.example_3_ui.component.TextFieldWithLabel
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun SignupScreen3(navController: NavController) {
    val constraintSet = ConstraintSet{
        val topHeader = createRefFor("topHeader")
        val headerWithText = createRefFor("headerWithText")
        val subHeading = createRefFor("subHeading")
        val nameTextField = createRefFor("nameTextField")
        val emailTextField = createRefFor("emailTextField")
        val passwordTextField = createRefFor("passwordTextField")
        val rowWithCheckBox = createRefFor("rowWithCheckBox")
        val gradientButton = createRefFor("gradientButton")
        val googleButton = createRefFor("googleButton")
        val facebookButton = createRefFor("facebookButton")
        val clickableText3 = createRefFor("clickableText3")

        constrain(topHeader){
            top.linkTo(parent.top, margin = 15.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(headerWithText){
            top.linkTo(topHeader.bottom, margin = 16.dp)
            start.linkTo(topHeader.start)
        }
        constrain(subHeading){
            top.linkTo(headerWithText.bottom, margin = 10.dp)
        }
        constrain(nameTextField){
            top.linkTo(subHeading.bottom, margin = 16.dp)
        }
        constrain(emailTextField){
            top.linkTo(nameTextField.bottom, margin = 16.dp)
        }
        constrain(passwordTextField){
            top.linkTo(emailTextField.bottom, margin = 16.dp)
        }
        constrain(rowWithCheckBox){
            top.linkTo(passwordTextField.bottom, margin = 16.dp)
        }
        constrain(gradientButton){
            top.linkTo(rowWithCheckBox.bottom, margin = 16.dp)
        }
        constrain(googleButton){
            top.linkTo(gradientButton.bottom, margin = 12.dp)
        }
        constrain(facebookButton){
            top.linkTo(googleButton.bottom, margin = 12.dp)
        }
        constrain(clickableText3){
            bottom.linkTo(parent.bottom, margin = 16.dp)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF020202))
            .padding(16.dp)
    ) {
        CustomHeaderDraw(
            modifier = Modifier.layoutId("topHeader")
        )
        HeaderTextWithIcon(
            modifier = Modifier.layoutId("headerWithText"),
            value = "Create an account",
            icon = painterResource(id = R.drawable.start_icon)
        )

        SubHeadingText(
            modifier = Modifier.layoutId("subHeading"),
            value = "Welcome! Please enter your details."
        )
        TextFieldWithLabel(
            modifier = Modifier.layoutId("nameTextField"),
            label = "Name",
            icon = Icons.Rounded.Person,
            placeHolder = "Enter your name"
        )

        TextFieldWithLabel(
            modifier = Modifier.layoutId("emailTextField"),
            label = "Email",
            icon = Icons.Rounded.Email,
            placeHolder = "Enter your email"
        )

        PasswordFieldWithLabel(
            modifier = Modifier.layoutId("passwordTextField"),
            label = "Password",
            placeHolder = "Enter your password",
            icon = Icons.Rounded.Lock
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("rowWithCheckBox"),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CheckBoxWithText(text = "Must be at least 8 characters")
        }

        GradientButton(
            modifier = Modifier.layoutId("gradientButton") ,
            value = "Sign Up",
            onClickButton = {navController.navigate(Router.VerifyRoute3.route)}
        )

        IconWithTextButton(
            onClickButton = {},
            painter = painterResource(id = R.drawable.google_icon_logo_svgrepo_com),
            title = "Sign Up with Google",
            modifier = Modifier.layoutId("googleButton")
        )

        IconWithTextButton(
            onClickButton = {},
            painter = painterResource(id = R.drawable.facebook_3_logo_svgrepo_com),
            title = "Sign Up with Facebook",
            modifier = Modifier.layoutId("facebookButton")
        )

        CustomClickableText3(
            tryToLogin = true,
            onTextSelected = {
                navController.navigate(Router.LoginRoute3.route){
                    popUpTo(Router.RegisterRoute3.route)
                }
            },
            modifier = Modifier.layoutId("clickableText3")
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    SignupScreen3(navController = rememberNavController())
}