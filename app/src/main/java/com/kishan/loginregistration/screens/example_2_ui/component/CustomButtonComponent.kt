package com.kishan.loginregistration.screens.example_2_ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.R
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun CustomUserButton(
    value:String,
    onButtonClick:()->Unit
) {
    Button(
        onClick = onButtonClick,
        contentPadding = PaddingValues(vertical = 14.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xE86F68FF)
        ),
        shape = RoundedCornerShape(8.dp)

    ) {
        Text(
            text = value,
            style = TextStyle(
                fontFamily = dmSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun IconButtonComponent(icon:Painter) {
    Button(
        onClick = {},
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        modifier = Modifier
            .size(60.dp)
            .shadow(elevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
       Box(
           modifier = Modifier
               .size(60.dp)
               .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
           contentAlignment = Alignment.Center
       ){
           Icon(
               painter = icon,
               contentDescription = "",
               tint = Color.Unspecified,
               modifier = Modifier.size(30.dp)
           )
       }
    }
}

@Composable
fun DividerWithTextComponent(text:String) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color(0xFF888888),
            thickness = 1.dp
        )
        Text(
            text = text,
            style = TextStyle(
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF888888),
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color(0xFF888888),
            thickness = 1.dp
        )
    }
}



@Preview
@Composable
private fun DefaultButtonPreview() {
//    CustomUserButton(value = "Sign Up", onButtonClick = {})
//    DividerWithTextComponent(text = "Or Sign up with")
    IconButtonComponent(icon = painterResource(id = R.drawable.google_icon))
}