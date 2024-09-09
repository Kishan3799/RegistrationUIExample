package com.kishan.loginregistration.component

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.ui.theme.Blue100


@Composable
fun HeadingTextComponent(
    text:String
) {
    Text(
        text = text,
        color = Color.Black,
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SmallTextComponent(text: String, sizeOfText: TextUnit) {
    Text(
        text = text,
        color = Color.Gray,
        style = TextStyle(
            fontSize = sizeOfText,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun CustomClickableText(
    tryToLogin:Boolean = true,
    onTextSelected:(String)-> Unit
) {
    val initialText = if(tryToLogin) "Already have an account?" else "Don't have an account?"
    val loginText = if(tryToLogin) "Sign In" else "Sign Up"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Blue100)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span->
                Log.d("CustomClickableTextComponent", "{${span.item}}")
                if(span.item == loginText){
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun CustomCheckBox(value:String,onClick:()->Unit) {
    val checkedValue = remember { mutableStateOf(false)}
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically){
        Checkbox(checked = checkedValue.value, onCheckedChange = {
            checkedValue.value = !checkedValue.value
        })
        Text(
            text = value,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )
        Spacer(modifier = Modifier.width(30.dp))
        TextButton(onClick = onClick) {
            Text(text = "Forget Password" , fontSize = 18.sp, color = Blue100)
        }
        
    }
}

