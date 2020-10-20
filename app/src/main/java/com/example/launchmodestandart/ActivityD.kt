package com.example.launchmodestandart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_d.*

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        var name = intent.getStringExtra("nameActivityC")
        textView.text = name
        name += " D ->"

        buttonBack.setOnClickListener() {
            finish()
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityA::class.java)
            intent.putExtra("nameActivityD", name)
            startActivity(intent)

        }
    }
}