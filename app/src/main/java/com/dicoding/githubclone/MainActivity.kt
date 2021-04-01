package com.dicoding.githubclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.databinding.ActivityMainBinding
import com.dicoding.githubclone.databinding.ToolbarBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding: ToolbarBinding

    private lateinit var rvProfiles: RecyclerView

    private var list: ArrayList<Profiles> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton = toolbarBinding.backGroup
        backButton.setOnClickListener(this)

        rvProfiles = binding.rvGithubProfiles
        rvProfiles.setHasFixedSize(true)

        list.addAll(ProfilesData.listData)
        showRecyclerList()
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.back_group -> {
                Toast.makeText(applicationContext,"App under construction",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showRecyclerList(){
        rvProfiles.layoutManager = LinearLayoutManager(this)
        val listProfileAdapter = ListProfileAdapter(list)
        rvProfiles.adapter = listProfileAdapter
    }
}