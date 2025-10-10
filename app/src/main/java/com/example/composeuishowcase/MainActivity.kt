package com.example.composeuishowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeuishowcase.catalog.CatalogScreen
import com.example.composeuishowcase.nav.Routes
import com.example.composeuishowcase.screens.HomeScreen
import com.example.composeuishowcase.screens.WeatherScreen
import com.example.composeuishowcase.theme.ShowcaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowcaseTheme {
                Scaffold { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                    ) {
                        AppNavigation()
                    }
                }

            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(
                onNavigateToCatalog = { navController.navigate(Routes.Catalog.route) },
                onNavigateToWeather = { cityName ->
                    navController.navigate(Routes.Weather.createRoute(cityName))
                }
            )
        }
        composable(Routes.Catalog.route) {
            CatalogScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Routes.Weather.route) { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName") ?: "Unknown"
            WeatherScreen(
                cityName = cityName,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}