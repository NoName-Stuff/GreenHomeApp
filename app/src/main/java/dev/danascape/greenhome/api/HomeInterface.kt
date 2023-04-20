package dev.danascape.greenhome.api

import dev.danascape.greenhome.model.BuildModel
import retrofit2.Call
import retrofit2.http.GET

interface HomeInterface {
    @GET("plant.json")
    fun getBuildInfo(): Call<BuildModel>
}