package com.example.composeuishowcase.catalog

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
fun CatalogScreen(
    onNavigateToWeather: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    // Sample list of cities for catalog
    val cities = listOf(
        CityInfo("Japan", 70, 139.6917, 25.0, "Cloudy"),
        CityInfo("Brazil", 80, -43.1729, 28.0, "Rainy"),
        CityInfo("Germany", 60, 13.4050, 15.0, "Foggy")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "City Catalog",
            style = MaterialTheme.typography.headlineMedium
        )
        cities.forEach { city ->
            Button(
                onClick = { onNavigateToWeather(city.countryName) },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("View Weather for ${city.countryName}")
            }
        }
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Back to Home")
        }
    }
}
