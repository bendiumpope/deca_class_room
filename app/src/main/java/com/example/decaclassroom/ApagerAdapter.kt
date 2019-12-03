package com.example.decaclassroom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ApagerAdapter(var fragmentManager: FragmentManager, var numOfTabs: Int) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        val fragment = when (position) {
            0 -> ArticlesFragment()
            1 -> BookFragment()
            2 -> VideoFragment()
            else -> null
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}