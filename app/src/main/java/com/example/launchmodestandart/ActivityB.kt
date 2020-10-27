package com.example.launchmodestandart

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_b.*


class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        var name = "${intent.getStringExtra("nameActivityA")} ->"
        textView.text = name
        name += " B ->"

        buttonBack.setOnClickListener() {
            onBackPressed()
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityC::class.java)
            intent.putExtra("nameActivityB", name)
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