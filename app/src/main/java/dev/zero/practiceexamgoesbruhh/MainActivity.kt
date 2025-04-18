package dev.zero.practiceexamgoesbruhh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.zero.practiceexamgoesbruhh.screens.LoginScreen
import dev.zero.practiceexamgoesbruhh.screens.RecipeApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavGraph()
            }
        }
    }
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("recipes") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("recipes") {
            RecipeApp()
        }
    }
}

