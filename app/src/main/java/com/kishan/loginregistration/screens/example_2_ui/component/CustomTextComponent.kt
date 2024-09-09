package com.kishan.loginregistration.screens.example_2_ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.R
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun HeaderTextWithIcon(
    value:String,
    icon:Painter
) {
   Row(verticalAlignment = Alignment.CenterVertically) {
       Text(text = value, style = TextStyle(
           fontFamily = dmSansFontFamily,
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold
       ))
       Spacer(modifier = Modifier.width(4.dp))
       Icon(
           painter = icon,
           contentDescription = "",
           tint = Color.Unspecified,
           modifier = Modifier.size(24.dp)
       )
   } 
}

@Composable
fun SubHeadingText(value: String) {
    Text(
        text = value,
        style = TextStyle(
            fontFamily = dmSansFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF888888)
        )
    )
}

@Composable
fun CustomClickableText2(
    tryToLogin: Boolean = true,
    onTextSelected: (String) -> Unit,
) {
    val initialText = if(tryToLogin) "Already have an account? " else "Don't have an account? "
    val endedText = if(tryToLogin) "Log in" else "Sign up"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontFamily = dmSansFontFamily, fontWeight = FontWeight.Medium,color = Color(0xFF888888))){
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }
        withStyle(style = SpanStyle(fontFamily = dmSansFontFamily, fontWeight = FontWeight.SemiBold, color = Color(0xE86F68FF))){
            pushStringAnnotation(tag = endedText, annotation = endedText)
            append(endedText)
        }
    }

    ClickableText(
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontFamily = dmSansFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span->
                    Log.d("CustomClickableTextComponent", "{${span.item}}")
                    if(span.item == endedText){
                        onTextSelected(span.item)
                    }
                }
        }
    )
}

@Preview
@Composable
private fun DefaultPreview() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = Color.White)) {
        HeaderTextWithIcon(value = "Login In", icon = painterResource(id = R.drawable.start_icon))
        SubHeadingText(value ="Welcome" )
        CustomClickableText2 {

        }
    }
}