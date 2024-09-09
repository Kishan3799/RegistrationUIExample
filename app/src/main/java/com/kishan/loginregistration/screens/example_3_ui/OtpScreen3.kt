package com.kishan.loginregistration.screens.example_3_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.loginregistration.R
import com.kishan.loginregistration.navigation.Router
import com.kishan.loginregistration.screens.example_3_ui.component.CustomHeaderDraw
import com.kishan.loginregistration.screens.example_3_ui.component.GradientButton
import com.kishan.loginregistration.screens.example_3_ui.component.HeaderTextWithIcon
import com.kishan.loginregistration.screens.example_3_ui.component.OtpTextField3
import com.kishan.loginregistration.screens.example_3_ui.component.SubHeadingText
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun OtpScreen3(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF020202))
            .padding(16.dp)
    ) {
        val (topHeader, headerWithText, subHeading, otpTextField, verifyButton, resendClikableText, backToLoginButton ) = createRefs()

        CustomHeaderDraw(modifier = Modifier.constrainAs(topHeader) {
            top.linkTo(parent.top, margin = 16.dp)
        })

        HeaderTextWithIcon(
            modifier = Modifier.constrainAs(headerWithText){
                top.linkTo(topHeader.bottom, margin = 24.dp)
            },
            value = "Check your email",
            icon = painterResource(id = R.drawable.start_icon)
        )

        SubHeadingText(modifier = Modifier.constrainAs(subHeading){
            top.linkTo(headerWithText.bottom, margin = 10.dp)
        }, value = "We sent a verification link to sara@cruz.com")

        OtpTextField3(modifier = Modifier.constrainAs(otpTextField){
            top.linkTo(subHeading.bottom, margin = 24.dp)
        })

        GradientButton(modifier = Modifier.constrainAs(verifyButton){
            top.linkTo(otpTextField.bottom, margin = 18.dp)
        }, value = "Verify email") {
            navController.navigate(Router.LoginRoute3.route){
                popUpTo(Router.VerifyRoute3.route){
                    inclusive = true
                }
            }
        }

        Row(modifier = Modifier
            .constrainAs(resendClikableText) {
                top.linkTo(verifyButton.bottom, margin = 16.dp)
                start.linkTo(verifyButton.start)
                end.linkTo(verifyButton.end)
            }
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text = "Didn't receive the email?", style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium
            ))
            Spacer(modifier = Modifier.width(5.dp))
            TextButton(onClick = {}, contentPadding = PaddingValues(0.dp) ) {
                Text(text = "Click to resend", style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                ))
            }
        }

        Row(modifier = Modifier.constrainAs(backToLoginButton){
            top.linkTo(resendClikableText.bottom, margin = 16.dp)
            start.linkTo(resendClikableText.start)
            end.linkTo(resendClikableText.end)
        }, verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back to Login", tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Back to log in", style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = dmSansFontFamily,
                color = Color.White
            ))
        }

    }

}

@Preview
@Composable
private fun DefaultPreview() {
    OtpScreen3(navController = rememberNavController())
}