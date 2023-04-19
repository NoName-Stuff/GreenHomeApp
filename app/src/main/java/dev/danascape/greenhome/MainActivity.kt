package dev.danascape.greenhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.danascape.greenhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        binding.imgPlant.setOnClickListener {
            Toast.makeText(this, "next page", Toast.LENGTH_SHORT).show()
        }
        
        setContentView(binding.root)
    }
}