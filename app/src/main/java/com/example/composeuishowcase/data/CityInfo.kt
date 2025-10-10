package com.example.composeuishowcase.data

import android.os.Parcel
import android.os.Parcelable

data class CityInfo(
    val countryName: String,
    val humidity: Int,
    val longitude: Double,
    val temperature: Double,
    val conditionName: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(countryName)
        parcel.writeInt(humidity)
        parcel.writeDouble(longitude)
        parcel.writeDouble(temperature)
        parcel.writeString(conditionName)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CityInfo> {
        override fun createFromParcel(parcel: Parcel): CityInfo = CityInfo(parcel)
        override fun newArray(size: Int): Array<CityInfo?> = arrayOfNulls(size)
    }
}