package com.example.launchmodestandart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity(), EnterNameFragmentCallback, EnterAvatarFragmentCallback,
    SignUpFragmentCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        replaceFragment(EnterNameFragment.newInstance(), false)

    }

    override fun showEnterAvatarFragment(name: String) {
        replaceFragment(EnterAvatarFragment.newInstance(name), true)
    }

    override fun showSignUpFragment(name: String, avatarPath: String) {
        replaceFragment(SignUpFragment.newInstance(name, avatarPath), true)
    }

    override fun restoreFragments() {
        supportFragmentManager.apply {
            beginTransaction().apply {
              popBackStack(EnterAvatarFragment::class.java.simpleName, POP_BACK_STACK_INCLUSIVE)
            }.commit()
        }
    }


    //enter name -> set avatar -> sign up

    private fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean) {

        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(
                    container.id,
                    fragment
                )
                if (isAddToBackStack) addToBackStack(fragment::class.java.simpleName)
            }.commit()
        }
    }
}