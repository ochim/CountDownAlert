package com.example.countdownalert

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.library.CountDownAlert

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener{
            CountDownAlert(this).show()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            CountDownAlert(this, 5).show()
        }

    }
}