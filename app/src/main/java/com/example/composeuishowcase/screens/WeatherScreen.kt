package com.example.composeuishowcase.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.composeuishowcase.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.data.WeatherDataGenerator

@Composable
fun WeatherScreen(
    cityName: String,
    onNavigateBack: () -> Unit
) {
    val weatherGenerator = WeatherDataGenerator()
    val cityInfo = weatherGenerator.generateRandomCityInfo().copy(countryName = cityName)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherItem(
            cityInfo = cityInfo,
            windCondition = "Fast Wind",
            weatherGenerator = weatherGenerator
        )
        Button(
            onClick = onNavigateBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}

@Composable
fun WeatherItem(cityInfo: CityInfo, windCondition: String, weatherGenerator: WeatherDataGenerator) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.weather_item_rectangle),
            contentDescription = "Weather Item Background",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            alpha = 1f
        )


        Column {
            Text(
                text = "${cityInfo.temperature.toInt()}°",
                fontSize = 48.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "H:${(cityInfo.temperature + 1).toInt()}° L:${(cityInfo.temperature - 3).toInt()}°",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "${cityInfo.countryName}, ${cityInfo.countryName}",
                fontSize = 16.sp,
                color = Color.White
            )
        }


        Column(horizontalAlignment = Alignment.End) {
            Image(
                painter = weatherGenerator.getWeatherIcon(cityInfo.conditionName),
                contentDescription = "Weather Icon for ${cityInfo.conditionName}",
                modifier = Modifier
                    .width(80.dp)
                    .height(60.dp)
            )
            Text(
                text = windCondition,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}