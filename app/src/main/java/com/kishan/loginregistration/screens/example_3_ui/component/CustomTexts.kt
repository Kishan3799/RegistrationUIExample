package com.kishan.loginregistration.screens.example_3_ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.ui.theme.dmSansFontFamily


@Composable
fun HeaderTextWithIcon(
    modifier: Modifier,
    value:String,
    icon: Painter
) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {
            Text(text = value,
                style = TextStyle(
                    fontFamily = dmSansFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF)
                )
            )
        Spacer(modifier = modifier.width(4.dp))
        Icon(
            painter = icon,
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = modifier.size(24.dp)
        )
    }
}

@Composable
fun SubHeadingText(modifier: Modifier, value: String) {
    Text(
        modifier = modifier,
        text = value,
        style = TextStyle(
            fontFamily = dmSansFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF888888)
        )
    )
}

