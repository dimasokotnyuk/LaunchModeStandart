package com.example.launchmodestandart

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_navigation_2.*

class EnterAvatarFragment : Fragment(R.layout.fragment_navigation_2) {

    companion object {
        const val KEY_NAME = "KEY_NAME"

        fun newInstance(name: String) = EnterAvatarFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_NAME, name)
            }
        }
    }

    private var callback: EnterAvatarFragmentCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = activity as? EnterAvatarFragmentCallback
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvName.text = arguments?.getString(KEY_NAME)
        bNextStep.setOnClickListener {
            callback?.showSignUpFragment(tvName.text.toString(), tvName.text.toString())
        }
    }
}