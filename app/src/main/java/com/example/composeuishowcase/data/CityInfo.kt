package com.example.composeuishowcase.data

import kotlinx.serialization.Serializable

@Serializable
data class CityInfo(
    val countryName: String,
    val humidity: Int,
    val longitude: Double,
    val temperature: Double,
    val conditionName: String
)