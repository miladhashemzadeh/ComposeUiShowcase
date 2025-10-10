package com.example.composeuishowcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.component.WeatherItem
import com.example.composeuishowcase.data.WeatherDataGenerator

@Composable
fun WeatherScreen(
    cityName: String, onNavigateBack: () -> Unit
) {
    val weatherGenerator = WeatherDataGenerator()
    val cityInfo = weatherGenerator.generateRandomCityInfo()
        .copy(countryName = cityName) // Override countryName with provided cityName

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherItem(
            cityInfo = cityInfo, windCondition = "Fast Wind", weatherGenerator = weatherGenerator
        )
        Button(
            onClick = onNavigateBack, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}

