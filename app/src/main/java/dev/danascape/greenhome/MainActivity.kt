package dev.danascape.greenhome

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.danascape.greenhome.databinding.ActivityMainBinding
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        binding.imgPlant.setOnClickListener {
            Intent(this, PlantActivity::class.java).also {
                startActivity(it)
            }
        }
        
        setContentView(binding.root)

    }
}