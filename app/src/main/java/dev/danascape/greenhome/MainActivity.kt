package dev.danascape.greenhome

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import dev.danascape.greenhome.databinding.ActivityMainBinding

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

        val radius = 20f


        setContentView(binding.root)

    }

    fun blur(
        viewToBlur: MainActivity = this,
        radius: Float = 16f,
        isAutoUpdate: Boolean = true,
        hasFixedTransformationMatrix: Boolean = true,
    ) {
        binding.blrView.setupWith(binding.blrView)
//            .setBlurAlgorithm(RenderScriptBlur(this.context))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(isAutoUpdate)
//            .setHasFixedTransformationMatrix(hasFixedTransformationMatrix)
    }
}