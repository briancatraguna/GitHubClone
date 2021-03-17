package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var backButton: RelativeLayout
    private lateinit var rvProfiles: RecyclerView
    private var list: ArrayList<Profiles> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backButton = findViewById(R.id.back_group)
        backButton.setOnClickListener(this)

        rvProfiles = findViewById(R.id.rv_github_profiles)
        rvProfiles.setHasFixedSize(true)
        rvProfiles.setOnClickListener(this)

        list.addAll(ProfilesData.listData)
        showRecyclerList()
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.back_group -> {
                Toast.makeText(applicationContext,"App under construction",Toast.LENGTH_SHORT).show()
            }
            R.id.rv_github_profiles -> {

            }
        }
    }

    private fun showRecyclerList(){
        rvProfiles.layoutManager = LinearLayoutManager(this)
        val listProfileAdapter = ListProfileAdapter(list)
        rvProfiles.adapter = listProfileAdapter
    }
}