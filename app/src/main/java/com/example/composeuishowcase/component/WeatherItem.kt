package com.example.composeuishowcase.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuishowcase.R
import com.example.composeuishowcase.data.CityInfo
import com.example.composeuishowcase.data.WeatherDataGenerator
import com.example.composeuishowcase.theme.LocalCustomGradients

@Composable
fun WeatherItem(cityInfo: CityInfo, windCondition: String, weatherGenerator: WeatherDataGenerator, onItemClick: (CityInfo) -> Unit) {
    val customGradients = LocalCustomGradients.current
    Box(Modifier.clickable { onItemClick(cityInfo) }) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .wrapContentHeight(),
            painter = painterResource(R.drawable.weather_item_rectangle),
            contentDescription = ""
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                //.background(customGradients.Gradient3)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
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
}