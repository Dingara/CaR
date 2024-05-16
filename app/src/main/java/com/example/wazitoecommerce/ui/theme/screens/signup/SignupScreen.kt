package com.example.wazitoecommerce.ui.theme.screens.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.data.AuthViewModel
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SIGN UP",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Orange
        )
        Image(painter = painterResource(id = R.drawable.bg),
            contentDescription = "woof",
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.FillBounds)


        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter yout full name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )


        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Enter email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Enter your password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                cursorColor = Orange,
                focusedBorderColor = Orange, // Orange color
                unfocusedBorderColor = Orange // Orange color
            ),
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)
        OutlinedButton(
            onClick = {
                authViewModel.signup(name, email, password)
                navController.navigate(LOGIN_URL)
            },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Orange),
            border = BorderStroke(1.dp, Orange),
            modifier = Modifier.padding(8.dp),
            enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
        ) {
            Text(text = "SUBMIT")
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = { navController.navigate(LOGIN_URL) },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Orange),
            border = BorderStroke(1.dp, Orange),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "SIGN IN")
        }


    }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    WazitoECommerceTheme {
        SignupScreen(navController = rememberNavController())
    }
}