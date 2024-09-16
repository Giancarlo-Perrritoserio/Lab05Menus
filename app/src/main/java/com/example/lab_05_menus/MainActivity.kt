package com.example.lab_05_menus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_05_menus.ui.theme.Lab05MenusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab05MenusTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Configuración del NavController
                    val navController = rememberNavController()
                    CustomNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CustomNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        // La pantalla principal utiliza CustomScaffold
        composable("home") { CustomScaffold(navController) }
        composable("profile") { ProfileScreen() }

        composable("notificaciones") { NotificationsScreen() }
        composable("menu") { MenuScreen() }
        composable("favorite") { FavoriteScreen() }
        composable("settings") { SettingsScreen() }
    }
}

