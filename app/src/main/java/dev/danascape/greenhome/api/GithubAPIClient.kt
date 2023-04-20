package dev.danascape.greenhome.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubAPIClient {
        private val BASE_URL = "https://raw.githubusercontent.com/Team-NoName/AutomatedFarm-infra/main/json/"
        private var mRetrofit: Retrofit? = null
        val client: Retrofit
            get() {
                if (mRetrofit == null) {
                    mRetrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                }
                return this.mRetrofit!!
                return mRetrofit!!
            }
}