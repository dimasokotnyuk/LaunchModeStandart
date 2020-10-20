package com.example.launchmodestandart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        if (intent.getStringExtra("nameActivityD") != null) {
            textView.text = intent.getStringExtra("nameActivityD")
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityB::class.java)
            intent.putExtra("nameActivityA", "A")
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        buttonBack.setOnClickListener() {
            finish()
        }

    }
}