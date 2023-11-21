package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MyApp() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val context = LocalContext.current
        var textNewValue by remember { mutableStateOf("") }
        var textNewValue2 by remember { mutableStateOf("") }
        val k_ctrl = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
            TextField(
                value = textNewValue,
                onValueChange = { newText -> textNewValue = newText },
                label = { Text(text = "Enter your Email") },
                placeholder = { Text(text = "example@gmail.com") },
                singleLine = true,
                maxLines = 2,
                modifier = Modifier.width(280.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "email icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, textNewValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "send Icon")

                    }
                }

            )
            TextField(
                value = textNewValue2,
                onValueChange = { newText -> textNewValue2 = newText },
                label = { Text(text = "Enter your Email") },
                placeholder = { Text(text = "example@gmail.com") },
                singleLine = true,
                maxLines = 2,
                modifier = Modifier.width(280.dp),
                //*********************************
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "email icon"
                    )
                },
                //****************************************
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            textNewValue2,
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "send Icon")

                    }
                },

                //************************
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Send
                ),
                //***********************
                keyboardActions = KeyboardActions(
                    onSend = {
                        k_ctrl?.hide()
                        Toast.makeText(context, "send btn clicked!", Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }

                )
            )

            BasicTextField(
                value = textNewValue,
                onValueChange = { textNewValue = it },
                modifier = Modifier
                    .background(Color.Yellow)
                    .width(250.dp),
                enabled = false
            )


        }
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    MyApplicationTheme {
        MyApp()
    }
}