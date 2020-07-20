package com.weatherS.android.logic

import androidx.lifecycle.liveData
import com.weatherS.android.logic.model.Place
import com.weatherS.android.logic.network.WeatherSNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = WeatherSNetwork.searchPlaces(query)
            if(placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            }
            else {
                Result.failure(RuntimeException("Response status is ${placeResponse}"))
            }
        } catch(e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result as Result<List<Place>>)
    }
}