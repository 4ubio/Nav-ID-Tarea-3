package com.example.navid_tarea3.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

fun getMessage(name: String, id_iest: Int): String {
    val id_isnd = listOf(19475, 19508, 19523, 19666, 21637, 21767, 22098, 22154, 22180, 22208, 22210)

    if (id_iest <= 10) {
        return "Bienvenido al laboratorio de ISND, estimado coordinador $name."
    } else if (id_iest <= 100) {
        return "Permiso autorizado para el profesor $name."
    } else if (id_iest <= 15000) {
        return "Acceso denegado a egresados."
    } else if (id_iest in id_isnd) {
        return "Alumno $name autorizado para uso del laboratorio."
    } else {
        return "Este laboratorio es de uso exclusivo para la carrera ISND."
    }
}

@Composable
fun message_screen(navController: NavHostController, name: String, id_iest: Int) {
    val message: String = getMessage(name, id_iest)

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF009688)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Regresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Message() {
    message_screen(navController = rememberNavController(), name = "Sebastián Rubio Quiroz", id_iest = 19666)
}