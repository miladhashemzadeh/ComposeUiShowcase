package com.example.composeuishowcase.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeuishowcase.catalog.CatalogScreen
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.screens.CityList
import com.example.composeuishowcase.screens.HomeScreen
import com.example.composeuishowcase.screens.WeatherList
import com.example.composeuishowcase.screens.WeatherScreen
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(
                onNavigateToCatalog = { navController.navigate(Routes.Catalog.route) },
                onNavigateToCityList = { navController.navigate(Routes.CityList.route) },
                onNavigateToWeatherList = { navController.navigate(Routes.WeatherList.route) }
            )
        }
        composable(Routes.CityList.route) {
            CityList(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToWeather = { cityInfoJson: String ->
                    navController.navigate("${Routes.Weather.route}?cityInfo=$cityInfoJson")
                }
            )
        }
        composable(Routes.WeatherList.route) {
            WeatherList(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToWeather = { cityInfoJson: String ->
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
            val cityInfo = if (cityInfoJson.isNotEmpty()) {
                Gson().fromJson(cityInfoJson, CityInfo::class.java)
            } else {
                CityInfo("Unknown", 50, 0.0, 20.0, "Sunny")
            }
            WeatherScreen(
                cityInfo = cityInfo,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}