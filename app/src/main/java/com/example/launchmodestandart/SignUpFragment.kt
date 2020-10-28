package com.example.launchmodestandart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.launchmodestandart.EnterAvatarFragment.Companion.KEY_NAME
import kotlinx.android.synthetic.main.fragment_navigation_3.*
import kotlin.random.Random

class SignUpFragment : Fragment(R.layout.fragment_navigation_3) {

    companion object {
        const val KEY_AVATAR_PATH = "KEY_AVATAR_PATH"

        fun newInstance(name: String, avatarPath: String) = SignUpFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_NAME, name)
                putString(KEY_AVATAR_PATH, avatarPath)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvName.text = arguments?.getString(KEY_NAME)
        view.setBackgroundColor(Random.nextInt())
    }
}