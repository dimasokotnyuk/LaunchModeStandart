package com.example.launchmodestandart

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
class ScreenSlidePagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 5

    override fun getItem(position: Int): Fragment = SimpleFragment.newInstance(position.toString())
}