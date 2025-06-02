package com.example.jnitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.jnitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var fact  = Factorial()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            val numText = binding.editTextText.text.toString()
            if (numText.isNotEmpty()) {
                val num = numText.toInt()
                fact.factorial(num)
                binding.res.text = fact.result.toString()

            } else {
                binding.res.text = "Please enter a number"
            }

        }

        // Example of a call to a native method
//        binding.sampleText.text = stringFromJNI()

    }

    /**
     * A native method that is implemented by the 'jnitest' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'jnitest' library on application startup.
        init {
            System.loadLibrary("jnitest")
        }
    }
}