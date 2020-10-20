package com.example.launchmodestandart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        var name = "${intent.getStringExtra("nameActivityA")} ->"
        textView.text = name
        name +=" B ->"

        buttonBack.setOnClickListener() {
            finish()
            onBackPressed()
        }

        buttonGo.setOnClickListener(){
            val intent = Intent(this,ActivityC::class.java)
            intent.putExtra("nameActivityB",name)
            startActivity(intent)
        }
    }
}