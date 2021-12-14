package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity2 : AppCompatActivity() {

    var TAG: String = "KOTLIN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.Main).launch{
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch{
            task2()
        }
    }

    suspend fun task1() {
        Log.d(TAG, "task1:Started ")
        yield()
        Log.d(TAG, "task1:Ended ")
    }
    suspend fun task2() {
        Log.d(TAG, "task2:Started ")
        yield()
        Log.d(TAG, "task2:Ended ")
    }

}