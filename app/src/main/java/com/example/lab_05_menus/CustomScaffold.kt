package com.example.lab_05_menus

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold(navController: NavController) {
    // Variable de estado para contar las veces que se presiona el botón
    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController = navController) },
        floatingActionButton = {
            CustomFAB(
                onFabClick = {
                    // Incrementar el contador de clics
                    clickCount++
                }
            )
        },
        content = { padding ->
            // Mostrar el valor del contador en la pantalla principal
            CustomContent(padding = padding, clickCount = clickCount)
        }
    )
}