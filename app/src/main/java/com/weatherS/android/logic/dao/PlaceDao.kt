package com.weatherS.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.weatherS.android.WeatherSApplication
import com.weatherS.android.logic.model.Place

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = WeatherSApplication.context.getSharedPreferences("weather_s", Context.MODE_PRIVATE)

}