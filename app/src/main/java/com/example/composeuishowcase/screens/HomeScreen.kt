package com.example.composeuishowcase.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.data.WeatherDataGenerator
import com.example.composeuishowcase.navigation.Routes
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(
    onNavigateToCatalog: () -> Unit,
    onNavigateToWeather: (String) -> Unit
) {
    val weatherGenerator = WeatherDataGenerator()
    val cityList = List(50) { weatherGenerator.generateRandomCityInfo() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cityList) { cityInfo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val cityInfoJson = Json.encodeToString(cityInfo)
                            onNavigateToWeather(cityInfoJson)
                        }
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cityInfo.countryName,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "${cityInfo.temperature.toInt()}°C",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}