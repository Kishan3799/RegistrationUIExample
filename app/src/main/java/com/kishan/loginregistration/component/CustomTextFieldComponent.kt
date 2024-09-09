package com.kishan.loginregistration.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.kishan.loginregistration.R
import com.kishan.loginregistration.ui.theme.Gray50

@Composable
fun CustomTextField(
    textValue:String,
    onTextValueChange:(String)->Unit,
    labelValue :String
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextValueChange,
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions.Default,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gray50,
            focusedLabelColor = Gray50,
            cursorColor = Gray50
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(shape = RoundedCornerShape(4.dp))

    )
}

@Composable
fun CustomPasswordField(
    textValue:String,
    onTextValueChange:(String)->Unit,
    labelValue :String,
) {
    val passowordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextValueChange,
        label = { Text(text = labelValue) },
        visualTransformation = if(passowordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gray50,
            focusedLabelColor = Gray50,
            cursorColor = Gray50
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
        trailingIcon = {
            val iconImage = if(passowordVisible.value){
                painterResource(id = R.drawable.baseline_visibility_24)
            }else{
                painterResource(id = R.drawable.baseline_visibility_off_24)
            }

            val discription=if(passowordVisible.value){
                stringResource(R.string.hide_password)
            }else{
                stringResource(R.string.show_password)
            }
            
            IconButton(onClick = {passowordVisible.value = !passowordVisible.value}) {
                Icon(painter = iconImage, contentDescription = discription)
            }
        },
    )
}
