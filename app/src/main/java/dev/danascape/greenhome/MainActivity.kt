package dev.danascape.greenhome

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.danascape.greenhome.api.GithubAPIClient
import dev.danascape.greenhome.api.HomeInterface
import dev.danascape.greenhome.databinding.ActivityMainBinding
import dev.danascape.greenhome.model.BuildModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var mApiService: HomeInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        mApiService = GithubAPIClient.client.create(HomeInterface::class.java)
        fetchUpdate()

        binding.btnRefresh.setOnClickListener {
            Toast.makeText(this, "Refreshing..", Toast.LENGTH_SHORT).show()
            fetchUpdate()
        }
        setContentView(binding.root)

    }

    private fun fetchUpdate() {
        val retrofit = mApiService!!.getBuildInfo()
        retrofit.enqueue(object: Callback<BuildModel> {

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<BuildModel>, response: Response<BuildModel>) {
                val resBody = response.body()
                if(resBody != null){
                    Log.d("retrofitResponse", "res: $resBody")
                    Log.d("retrofitResponse", "name: ${resBody.humidity}")
                    binding.tvHumidity.text = "Humidity: ${resBody.humidity}%"
                    binding.tvTemperature.text = "Temperature: ${resBody.temperature} C"
                    binding.tvSoil.text = "Soil Moisture: ${resBody.soilmoisture}%"
                    binding.tvAQI.text = "CO2 Level: ${resBody.airquality} ppm"
                }
            }

            override fun onFailure(call: Call<BuildModel>, t: Throwable) {
                Log.e("retrofitResponse","Error: ${t.message}")
            }
        })
    }
}