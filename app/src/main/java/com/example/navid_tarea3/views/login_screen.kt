package com.example.navid_tarea3.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun login_screen(navController: NavHostController) {
    var name: String by remember { mutableStateOf("") }
    var id_iest: Int by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {
                Text(text = "Ingresa tu nombre")
            },
            placeholder = {
                Text(text = "Por favor, ingresa tu nombre")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = id_iest.toString(),
            onValueChange = {id_iest = it.toInt()},
            label = {
                Text(text = "Ingresa tu ID IEST")
            },
            placeholder = {
                Text(text = "Por favor, ingresa tu ID IEST")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                navController.navigate("MessageScreen/$name/$id_iest")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF009688)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Ingresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Login() {
    login_screen(navController = rememberNavController())
}