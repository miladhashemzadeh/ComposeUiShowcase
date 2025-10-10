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
fun HomeScreen(
    onNavigateToCatalog: () -> Unit,
    onNavigateToWeather: (String) -> Unit
) {
    val sampleCity = CityInfo(
        countryName = "USA",
        humidity = 65,
        longitude = -74.0060,
        temperature = 22.5,
        conditionName = "Sunny"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Welcome to ${sampleCity.countryName}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Temperature: ${sampleCity.temperature}°C",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Button(
            onClick = onNavigateToCatalog,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Catalog")
        }
        Button(
            onClick = { onNavigateToWeather(sampleCity.countryName) },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("View Weather for ${sampleCity.countryName}")
        }
    }
}