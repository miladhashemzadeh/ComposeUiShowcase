package com.example.composeuishowcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuishowcase.component.WeatherItem
import com.example.composeuishowcase.data.WeatherDataGenerator
import com.example.composeuishowcase.theme.LocalCustomGradients
import com.google.gson.Gson

@Composable
fun WeatherList(modifier: Modifier = Modifier,
                onNavigateBack: () -> Unit,
                onNavigateToWeather: (String) -> Unit,) {
    val weatherGenerator = WeatherDataGenerator()
    val cityList = List(50) { weatherGenerator.generateRandomCityInfo() }
    val gradient = LocalCustomGradients.current.Gradient1Horizontal
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(gradient)
            .padding(32.dp)
    ) {
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