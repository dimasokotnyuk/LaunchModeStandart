package com.example.launchmodestandart

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_d.*

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        var name = intent.getStringExtra("nameActivityC")
        textView.text = name
        name += " D ->"

        buttonBack.setOnClickListener() {
            onBackPressed()
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityA::class.java)
            intent.putExtra("nameActivityD", name)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        showTasks()
    }

    private fun showTasks() {
        val mngr =
            getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val taskList = mngr.getRunningTasks(10)

        taskList.forEach {
            it.topActivity?.className?.let { name ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Log.e("TasksTag", "Task ${it.taskId} activity $name ")
                }
            }
        }
    }

}