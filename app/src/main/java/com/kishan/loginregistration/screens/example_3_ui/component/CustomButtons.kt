package com.kishan.loginregistration.screens.example_3_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.R
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun GradientButton(modifier: Modifier,value:String, onClickButton: ()-> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFFEB2279), Color(0xC4B22FEB))
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick =onClickButton,
        ) {
        Text(text = value, fontFamily = dmSansFontFamily, fontSize = 18.sp)
    }
}

@Composable
fun IconWithTextButton(onClickButton: () -> Unit, painter: Painter, title:String, modifier: Modifier) {
    Button(
        modifier = modifier.fillMaxWidth()
            .border(width = 2.dp, color = Color(0xFF3A3A3A), shape = RoundedCornerShape(8.dp)),
        contentPadding = PaddingValues(vertical = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick = onClickButton
    ) {
        Row {
            Icon(
                modifier = modifier.size(24.dp),
                painter = painter,
                contentDescription = title,
                tint = Color.Unspecified,
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(text = title, style = TextStyle(fontFamily = dmSansFontFamily, fontSize = 18.sp))
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
//    GradientButton(value = "Log In", onClickButton = {})
    IconWithTextButton(onClickButton = {}, painter = painterResource(id = R.drawable.google_icon_logo_svgrepo_com), title = "Log in with Google", modifier = Modifier)
}