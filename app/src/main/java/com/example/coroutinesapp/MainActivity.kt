package com.example.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import org.w3c.dom.Text
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var counterText: TextView
    var TAG:String= "KOTLIN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter)
    }

    fun updateCounter(view: android.view.View) {
        counterText.text = "${counterText.text.toString().toInt() + 1}"

    }

    private fun executeLongRunningTask(){
        for(i in 1..100000000000L){

        }
    }

    //Coroutines helps to implement functionality that can be suspended and later resumed
    //at specified point without blocking the thread

    //thread are in limited quantity so we use coroutines
    //Coroutines are just like threads(Lightweighted threads)but not threads.
    //Coroutines work on top of thread

    //Coroutines (Coroutines Scope And Coroutine Context)
    //1.  Coroutines Scope => defines lifetime
    //2.  Coroutine Context => in which threads are coroutines is to be executed

    //Dispatchers(basically a thread pool) is a way which tells, this is a set of thread in which you
    // have to work with coroutines or execute it.

    //Predefined Dispatcher
    //1.  Dispatchers.IO
    //2.  Dispatchers.Main
    //3.  Dispatchers.Default


    fun randomButton(view: android.view.View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "randomButton: 1 ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "randomButton: 2 ${Thread.currentThread().name}")

        }

        MainScope().launch(Dispatchers.Default) {

            Log.d(TAG, "randomButton: 3 ${Thread.currentThread().name}")

        }




        //thread are in limited quantity so we use coroutines
        //Coroutines are just like threads(Lightweighted threads)but not threads.
        //Coroutines work on top of thread

        //1 thread takes approx 2mb of space
        //thread created for long running task

       /* thread(start = true){
            executeLongRunningTask()

        }*/
    }
}