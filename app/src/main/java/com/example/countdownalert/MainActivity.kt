package com.example.countdownalert

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.countdownalert.databinding.ActivityMainBinding
import com.ochi.android.CountDownAlert

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            CountDownAlert(this).show()
        }

        binding.button2.setOnClickListener {
            it.visibility = View.INVISIBLE
            CountDownAlert(this).setInitialNumber(5).setCompletion(Runnable {
               it.visibility = View.VISIBLE
            }).show()
        }
    }
}