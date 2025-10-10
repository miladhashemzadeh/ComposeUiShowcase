package com.example.composeuishowcase.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.component.WeatherItem
import com.example.composeuishowcase.data.WeatherDataGenerator
import com.google.gson.Gson

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
        Button(
            onClick = onNavigateToCatalog,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Go to Catalog")
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cityList) { cityInfo ->
                WeatherItem(cityInfo, cityInfo.conditionName, weatherGenerator) {
                    val gson = Gson()
                    val cityInfoJson = gson.toJson(cityInfo)
                    onNavigateToWeather(cityInfoJson)
                }
            }
        }
    }
}