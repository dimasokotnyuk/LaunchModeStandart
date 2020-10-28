package com.example.launchmodestandart

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_navigation_1.*
import kotlin.random.Random

class EnterNameFragment : Fragment(R.layout.fragment_navigation_1) {

    companion object {
        fun newInstance() = EnterNameFragment().apply {
            arguments = Bundle()
        }
    }

    private var callback: EnterNameFragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = activity as? EnterNameFragmentCallback
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bNextStep.setOnClickListener {
            callback?.showEnterAvatarFragment(etName.text.toString())
        }
        view.setBackgroundColor(Random.nextInt())
    }
}