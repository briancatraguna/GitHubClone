package com.dicoding.githubclone.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.R
import com.dicoding.githubclone.adapter.ListProfileAdapter
import com.dicoding.githubclone.data.Profiles
import com.dicoding.githubclone.localdata.ProfilesData
import com.dicoding.githubclone.databinding.ActivityMainBinding
import com.dicoding.githubclone.fragment.FavoriteFragment
import com.dicoding.githubclone.fragment.HomeFragment
import com.dicoding.githubclone.fragment.ProfileFragment
import com.dicoding.githubclone.fragment.SettingsFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    //Make it a global variable
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(homeFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
                R.id.ic_favorite -> replaceFragment(favoriteFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

}