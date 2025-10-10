package com.example.composeuishowcase.nav

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Catalog : Routes("catalog")
    object Weather : Routes("weather/{cityName}") {
        fun createRoute(cityName: String) = "weather/$cityName"
    }
}