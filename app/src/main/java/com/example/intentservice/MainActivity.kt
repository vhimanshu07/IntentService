package com.example.intentservice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var serviceIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(
            "Service",
            "On create ${Thread.currentThread().id}"
        )
        serviceIntent = Intent(applicationContext, MyIntentService::class.java)
        binding.apply {
            start.setOnClickListener {
                startService(serviceIntent)
            }
            stopBtn.setOnClickListener {
                stopService(serviceIntent)
            }
        }


    }
}