package com.kishan.loginregistration.component

import androidx.annotation.IdRes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishan.loginregistration.R
import com.kishan.loginregistration.ui.theme.Blue100

@Composable
fun CustomButton(
    onButtonClick:()->Unit,
    buttonText:String
) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue100,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun CustomIconButton(
    onButtonClick: () -> Unit,
    icon:Painter
) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
        .shadow(elevation = 8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(vertical = 15.dp, horizontal = 15.dp)
                .size(38.dp)
        )
    }
}

