package com.example.launchmodestandart

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        Handler().postDelayed({
            supportFragmentManager.apply {
                beginTransaction().apply {
                    add(
                        container.id,
                        SimpleFragment.newInstance("Test Fragment 1 ]")
                    ) //(Fragment 1)
//                addToBackStack("Fragment1")
                }.commit()
            }
        }, 2000)

        Handler().postDelayed({
            supportFragmentManager.apply {
                beginTransaction().apply {
                    add(
                        container.id,
                        SimpleFragment.newInstance("Test Fragment 2")
                    ) //(Fragment 2)
                    addToBackStack("Fragment2")
                }.commit()
            }
        }, 4000)

        Handler().postDelayed({
            supportFragmentManager.apply {
                beginTransaction().apply {
                    add(
                        container.id,
                        SimpleFragment.newInstance("Test Fragment 3")
                    ) //(Fragment 2)
                    addToBackStack("Fragment2")
                }.commit()
            }
        }, 6000)


        Handler().postDelayed({
            finish()
        }, 8000)
//
//
//        Handler().postDelayed({
//            onBackPressed()
//        }, 10000)
//
//        Handler().postDelayed({
//            onBackPressed()
//        }, 12000)

    }

    //add to backstack  1 > 2 > 3 > 4
    //without backstack
}