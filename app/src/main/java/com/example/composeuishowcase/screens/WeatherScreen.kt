package com.example.composeuishowcase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.data.CityInfo

@Composable
fun WeatherScreen(
    cityName: String,
    onNavigateBack: () -> Unit
) {
    val cityInfo = CityInfo(
        countryName = cityName,
        humidity = when (cityName) {
            "Japan" -> 70
            "Brazil" -> 80
            "Germany" -> 60
            else -> 65
        },
        longitude = when (cityName) {
            "Japan" -> 139.6917
            "Brazil" -> -43.1729
            "Germany" -> 13.4050
            else -> -74.0060
        },
        temperature = when (cityName) {
            "Japan" -> 25.0
            "Brazil" -> 28.0
            "Germany" -> 15.0
            else -> 22.5
        },
        conditionName = when (cityName) {
            "Japan" -> "Cloudy"
            "Brazil" -> "Rainy"
            "Germany" -> "Foggy"
            else -> "Sunny"
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Weather for ${cityInfo.countryName}",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Temperature: ${cityInfo.temperature}°C",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Humidity: ${cityInfo.humidity}%",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "Longitude: ${cityInfo.longitude}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "Condition: ${cityInfo.conditionName}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}