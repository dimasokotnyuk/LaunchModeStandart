package com.example.launchmodestandart

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        var name = intent.getStringExtra("nameActivityB")
        textView.text = name
        name += " C ->"

        buttonBack.setOnClickListener() {
            onBackPressed()
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityD::class.java)
            intent.putExtra("nameActivityC", name)
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