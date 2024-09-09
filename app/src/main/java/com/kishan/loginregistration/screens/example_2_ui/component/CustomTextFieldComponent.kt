package com.kishan.loginregistration.screens.example_2_ui.component

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kishan.loginregistration.ui.theme.dmSansFontFamily

@Composable
fun TextFieldWithLabel(label:String, icon:ImageVector, placeHolder:String) {
    val textValue = remember {
        mutableStateOf("")
    }
    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        )

        OutlinedTextField(
            value = textValue.value,
            onValueChange = { textValue.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFF888888)
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF888888),
                focusedBorderColor = Color(0xFF888888),
                cursorColor = Color(0xFF888888),
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions.Default
        )
    }
}

@Composable
fun PasswordFieldWithLabel(label: String, placeHolder: String, icon: ImageVector) {
    val password = remember {
        mutableStateOf("")
    }
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(8.dp)),
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
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFF888888)
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF888888),
                focusedBorderColor = Color(0xFF888888),
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
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.padding(0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = !isChecked.value },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xE86F68FF)
            ),
            modifier = Modifier
                .size(10.dp)
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.width(40.dp))
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
fun OtpTextField() {
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
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = if(isFocused) Color(0xE86F68FF) else Color(0xD26D18FF),
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
        modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreviewOfTextField() {
    OtpTextField()
//    CheckBoxWithText(text = "Remember for 30days")
//    PasswordFieldWithLabel(label = "Password", icon = Icons.Outlined.Lock, placeHolder = "Enter your password")
}