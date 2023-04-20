package dev.danascape.greenhome.model

import com.google.gson.annotations.SerializedName

data class BuildModel(
    @SerializedName("humidity")
    val humidity: String,
    val temperature: String,
    val soilmoisture: String,
    val airquality: String
)
