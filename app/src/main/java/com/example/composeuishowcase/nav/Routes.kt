package com.example.composeuishowcase.nav

sealed class Routes(val route: String) {
    object Home : Routes("home")

    object CityList : Routes("citylist")

    object WeatherList : Routes("weatherlist")

    object CityDetail : Routes("citydetail")
    object Catalog : Routes("catalog")
    object Weather : Routes("weather/{cityName}")
}