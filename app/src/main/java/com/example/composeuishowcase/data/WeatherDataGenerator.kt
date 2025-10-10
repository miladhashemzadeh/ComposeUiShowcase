package com.example.composeuishowcase.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.composeuishowcase.R
import kotlin.random.Random

class WeatherDataGenerator {
    private val countries = listOf("Japan", "Brazil", "Germany", "Canada", "USA")
    private val conditions = listOf("Mid Rain", "Fast Wind", "Showers", "Tornado", "Partly Cloudy")

    fun generateRandomCityInfo(): CityInfo {
        val randomCountry = countries[Random.nextInt(countries.size)]
        val randomHumidity = Random.nextInt(0, 101)
        val randomLongitude = Random.nextDouble(-180.0, 180.0)
        val randomTemperature = Random.nextDouble(-20.0, 40.0)
        val randomCondition = conditions[Random.nextInt(conditions.size)]

        return CityInfo(
            countryName = randomCountry,
            humidity = randomHumidity,
            longitude = randomLongitude,
            temperature = randomTemperature,
            conditionName = randomCondition
        )
    }

    @Composable
    fun getWeatherIcon(conditionName: String): Painter {
        return when (conditionName) {
            "Mid Rain" -> painterResource(id = R.drawable.mid_rain)
            "Fast Wind" -> painterResource(id = R.drawable.fast_wind)
            "Showers" -> painterResource(id = R.drawable.angled_rain)
            "Tornado" -> painterResource(id = R.drawable.tornado)
            "Partly Cloudy" -> painterResource(id = R.drawable.fast_wind)
            else -> painterResource(id = R.drawable.fast_wind) // Default to fast_wind for unknown conditions
        }
    }
}