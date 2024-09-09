package com.kishan.loginregistration.screens.example_3_ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun TextFieldWithLabel(modifier: Modifier, label:String, icon: ImageVector, placeHolder:String) {
    val textValue = remember {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )

        OutlinedTextField(
            value = textValue.value,
            onValueChange = { textValue.value = it },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color(0xFF363636)),
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = Color(0xFF888888),
                )
            },
            placeholder = {
                Text(
                    text = placeHolder,
                    style = TextStyle(
                        fontFamily = dmSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    color = Color(0xFF888888)
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF363636),
                focusedBorderColor = Color(0xFF363636),
                cursorColor = Color(0xFF888888),
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions.Default,
        )
    }
}

@Composable
fun PasswordFieldWithLabel(modifier: Modifier,label: String, placeHolder: String, icon: ImageVector) {
    val password = remember {
        mutableStateOf("")
    }
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    Column (modifier=modifier){
        Text(
            text = label,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    color = Color(0xFF363636)
                ),
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = Color(0xFF888888),
                )
            },
            placeholder = {
                Text(
                    text = placeHolder,
                    style = TextStyle(
                        fontFamily = dmSansFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    color = Color(0xFF888888)
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF363636),
                focusedBorderColor = Color(0xFF363636),
                cursorColor = Color(0xFF888888),
            ),
            shape = RoundedCornerShape(8.dp),
            visualTransformation = if(isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val iconImage = if(isPasswordVisible.value) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility
                val desc = if(isPasswordVisible.value) "Hide Password" else "Show Password"
                IconButton(onClick = {isPasswordVisible.value = !isPasswordVisible.value}) {
                    Icon(imageVector = iconImage, contentDescription = desc, tint = Color(0xFF888888))
                }
            }
        )
    }
}

@Composable
fun CheckBoxWithText(text:String){
    val isChecked = remember {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = !isChecked.value },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xE8FFFFFF),
                checkmarkColor = Color(0xFF0A0A0A)
            ),
            modifier = Modifier
                .size(10.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = text,
            style = TextStyle(
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
            ),
            color = Color(0xFF888888)
        )
    }
}

@Composable
fun CustomClickableText3(
    tryToLogin: Boolean = true,
    onTextSelected: (String) -> Unit,
    modifier: Modifier
) {
    val initialText = if(tryToLogin) "Already have an account? " else "Don't have an account? "
    val endedText = if(tryToLogin) "Log in" else "Sign up"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontFamily = dmSansFontFamily, fontWeight = FontWeight.Normal,color = Color(0xFF888888))){
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }
        withStyle(style = SpanStyle(fontFamily = dmSansFontFamily, fontWeight = FontWeight.Medium, color = Color(0xFFFFFFFF))){
            pushStringAnnotation(tag = endedText, annotation = endedText)
            append(endedText)
        }
    }

    ClickableText(
        modifier = modifier.fillMaxWidth(),
        style = TextStyle(
            fontFamily = dmSansFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
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

@Composable
fun OtpTextField3(modifier: Modifier=Modifier) {
    var otpValue by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpValue,
        onValueChange = {
            if(it.length <= 4)
                otpValue = it
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(4){ index->
                    val char = when{
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }
                    val isFocused = otpValue.length == index
                    Text(
                        modifier = modifier
                            .width(48.dp)
                            .height(48.dp)
                            .background(
                                color = Color(0xFF313131),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = if(isFocused) 2.dp else 1.dp,
                                brush = Brush.linearGradient(
                                    if (isFocused) listOf(Color(0xFFEB2279), Color(0x7A241DFF), Color(0xFFEB2279), Color(0x7A241DFF)) else listOf(Color(
                                        0xFF1F1E1E
                                    ), Color(0xFF585858)
                                    ),
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(4.dp),
                        text = char,
                        fontFamily = dmSansFontFamily,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color(0xFF888888),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview
@Composable
private fun DefaultPreview() {
        OtpTextField3()
//    CustomClickableText3 {
//
//    }
//    CheckBoxWithText(text = "Remember")
//    TextFieldWithLabel(label = "Email", icon = Icons.Rounded.Email, placeHolder = "Enter your email")
//    PasswordFieldWithLabel(label = "Password", placeHolder = "Enter your password", icon = Icons.Rounded.Lock)
}