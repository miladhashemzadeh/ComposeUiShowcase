package com.example.composeuishowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeuishowcase.catalog.CatalogScreen
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.nav.Routes
import com.example.composeuishowcase.screens.HomeScreen
import com.example.composeuishowcase.screens.WeatherScreen
import com.example.composeuishowcase.theme.ShowcaseTheme
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowcaseTheme {
                Scaffold { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
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
                onNavigateToWeather = { cityInfoJson ->
                    navController.navigate("${Routes.Weather.route}?cityInfo=$cityInfoJson")
                }
            )
        }
        composable(Routes.Catalog.route) {
            CatalogScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Routes.Weather.route) { backStackEntry ->
            val cityInfoJson = backStackEntry.arguments?.getString("cityInfo") ?: ""
            val cityInfo = Json.decodeFromString<CityInfo>(cityInfoJson)
            WeatherScreen(
                cityInfo = cityInfo,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}