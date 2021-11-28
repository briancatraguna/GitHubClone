package com.dicoding.githubclone.activity

import android.database.ContentObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.fragment.app.Fragment
import com.dicoding.githubclone.R
import com.dicoding.githubclone.data.FavoriteUser
import com.dicoding.githubclone.database.DatabaseContract
import com.dicoding.githubclone.database.MappingHelper
import com.dicoding.githubclone.databinding.ActivityMainBinding
import com.dicoding.githubclone.fragment.FavoriteFragment
import com.dicoding.githubclone.fragment.HomeFragment
import com.dicoding.githubclone.fragment.SettingsFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    val users: ArrayList<FavoriteUser> = ArrayList<FavoriteUser>()

    //Make it a global variable
    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object: ContentObserver(handler){
            override fun onChange(selfChange: Boolean) {
                loadUsers()
            }
        }
        contentResolver.registerContentObserver(DatabaseContract.UserColumns.CONTENT_URI,true,myObserver)

        replaceFragment(homeFragment)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_favorite -> replaceFragment(favoriteFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
            }
            true
        }
    }

    private fun loadUsers() {
        val cursor = contentResolver.query(DatabaseContract.UserColumns.CONTENT_URI,null,null,null,null)
        users.addAll(MappingHelper.mapCursorToArrayList(cursor))
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

}