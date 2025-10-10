package com.example.composeuishowcase.catalog

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
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.data.WeatherDataGenerator

@Composable
fun CatalogScreen(
    onNavigateBack: () -> Unit
) {
    val weatherGenerator = WeatherDataGenerator()
    val staticCityInfo = CityInfo(
        countryName = "Tokyo",
        humidity = 70,
        longitude = 139.6917,
        temperature = 25.0,
        conditionName = "Mid Rain"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherItem(
            cityInfo = staticCityInfo,
            windCondition = "Fast Wind",
            weatherGenerator = weatherGenerator
        )
        Button(
            onClick = onNavigateBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Back to Home")
        }
    }
}