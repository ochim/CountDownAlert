package com.example.countdownalert

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.countdownalert.databinding.ActivityMainBinding
import com.ochi.android.CountDownAlert

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            CountDownDialogFragment().show(supportFragmentManager, "a")
        }

        binding.button2.setOnClickListener {
            it.visibility = View.INVISIBLE
            CountDownDialogFragment(5, {
                it.visibility = View.VISIBLE
            }).show(supportFragmentManager, "b")
        }
    }
}

class CountDownDialogFragment(val initialNumber: Int=3 , val completion: Runnable?=null) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            CountDownAlert(it).setInitialNumber(initialNumber).setCompletion({
                dismiss()
                completion?.run()
            })
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}