package com.dicoding.consumerapp

import android.database.ContentObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.consumerapp.adapter.FavoriteAdapter
import com.dicoding.consumerapp.data.FavoriteUser
import com.dicoding.consumerapp.database.DatabaseContract
import com.dicoding.consumerapp.database.MappingHelper
import com.dicoding.consumerapp.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var favUsers: ArrayList<FavoriteUser>
    private lateinit var rvUsers: RecyclerView
    private val listUserAdapter = FavoriteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadUsers()
        rvUsers = binding.rvFavorites

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object: ContentObserver(handler){
            override fun onChange(selfChange: Boolean) {
                loadUsers()
            }
        }

        contentResolver.registerContentObserver(DatabaseContract.UserColumns.CONTENT_URI,true,myObserver)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = listUserAdapter
    }

    private fun loadUsers() {
        val cursor = contentResolver.query(DatabaseContract.UserColumns.CONTENT_URI,null,null,null,null)
        favUsers = MappingHelper.mapCursorToArrayList(cursor)
        listUserAdapter.setData(favUsers)
    }
}