package com.example.navid_tarea3.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navid_tarea3.views.login_screen
import com.example.navid_tarea3.views.message_screen

@Composable
fun NavManager() {
    var navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "LoginScreen") {
        //Definiendo Rutas
        composable(route = "LoginScreen") {
            login_screen(navController)
        }

        composable(route = "MessageScreen/{name}/{id_iest}", arguments =
        listOf(
            navArgument("name") {type = NavType.StringType},
            navArgument("id_iest") {type = NavType.IntType}
        )) {
            parameters ->
                val name = parameters.arguments?.getString("name") ?: ""
                val id_iest = parameters.arguments?.getInt("id_iest") ?: 0

            message_screen(navController, name, id_iest)
        }
    }
}