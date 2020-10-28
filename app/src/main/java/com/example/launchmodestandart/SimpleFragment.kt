package com.example.launchmodestandart

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test.*
import kotlin.random.Random

class SimpleFragment : Fragment(R.layout.fragment_test) {

    companion object {
        fun newInstance(test: String) = SimpleFragment().apply {
            arguments = Bundle().apply {
                putString("TEST_KEY", test)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTest.text = arguments?.getString("TEST_KEY")
        view.setBackgroundColor(Random.nextInt())
    }
}