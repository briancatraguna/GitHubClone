package com.dicoding.githubclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    //Make it a global variable
    private lateinit var rvProfiles: RecyclerView

    private var list: ArrayList<Profiles> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = binding.toolbar.backGroup
        backButton.setOnClickListener{
            Toast.makeText(applicationContext,"App under construction",Toast.LENGTH_SHORT).show()
        }

        rvProfiles = binding.rvGithubProfiles
        rvProfiles.setHasFixedSize(true)

        list.addAll(ProfilesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvProfiles.layoutManager = LinearLayoutManager(this)
        val listProfileAdapter = ListProfileAdapter(list)
        rvProfiles.adapter = listProfileAdapter
    }
}