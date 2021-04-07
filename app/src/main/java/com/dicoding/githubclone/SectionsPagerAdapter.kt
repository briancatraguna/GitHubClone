package com.dicoding.githubclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    var username: String? = null

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = FollowersFragment.newInstance(username.toString())
            1 -> fragment = FollowingFragment.newInstance(username.toString())
        }
        return fragment as Fragment
    }
}