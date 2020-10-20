package com.example.launchmodestandart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        var name = intent.getStringExtra("nameActivityB")
        textView.text = name
        name += " C ->"

        buttonBack.setOnClickListener() {
            finish()
        }

        buttonGo.setOnClickListener() {
            val intent = Intent(this, ActivityD::class.java)
            intent.putExtra("nameActivityC", name)
            startActivity(intent)
        }
    }
}