package com.kishan.loginregistration.screens.example_2_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kishan.loginregistration.R
import com.kishan.loginregistration.screens.example_2_ui.component.CustomUserButton
import com.kishan.loginregistration.screens.example_2_ui.component.HeaderTextWithIcon
import com.kishan.loginregistration.screens.example_2_ui.component.OtpTextField
import com.kishan.loginregistration.screens.example_2_ui.component.SubHeadingText

@Composable
fun VerifyOtpScreen(navController: NavController) {
    Column(
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
        HeaderTextWithIcon(value = "Check your email", icon = painterResource(id = R.drawable.start_icon))
        Spacer(modifier = Modifier.height(8.dp))
        SubHeadingText(value = "We sent a verification link to sara@cruz.com")
        Spacer(modifier = Modifier.height(16.dp))
        OtpTextField()
        Spacer(modifier = Modifier.height(18.dp))
        CustomUserButton(value = "Verify email") {

        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    VerifyOtpScreen(navController = rememberNavController())
}