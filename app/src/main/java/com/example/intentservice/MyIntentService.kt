package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.math.nextTowards

/**
 * Created by Himanshu Verma on 15/06/24.
 **/
class MyIntentService : IntentService("dfv ") {
    var randomValue: Double = 0.0
    var isRandomGeneratorOn: Boolean = false
    private val maxValue: Int = 100

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onHandleIntent(intent: Intent?) {
        isRandomGeneratorOn = true
        startRandomGenerator()
    }


    private fun startRandomGenerator() {
        while (isRandomGeneratorOn) {
            try {
                Thread.sleep(1000)
                if (isRandomGeneratorOn) {
                    randomValue = Math.random().nextTowards(maxValue.toDouble())
                    Log.d(
                        "Service",
                        "Started and Thread id :- ${Thread.currentThread().id} random number is : $randomValue"
                    )
                }

            } catch (e: Exception) {
                Log.d(
                    "Service",
                    "Thread interrupted"
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRandomGeneratorOn = false
    }
}