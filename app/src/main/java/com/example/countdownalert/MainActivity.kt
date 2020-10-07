package com.example.countdownalert

import android.os.Bundle
import android.view.View
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
            it.visibility = View.INVISIBLE
            CountDownAlert(this).setInitialNumber(5).setCompletion(Runnable {
               it.visibility = View.VISIBLE
            }).show()
        }
    }
}