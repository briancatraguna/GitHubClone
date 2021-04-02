package com.dicoding.githubclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    //Make it a global variable
    private lateinit var rvProfiles: RecyclerView

    private var list: ArrayList<Profiles> = arrayListOf()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvProfiles = binding.rvGithubProfiles
        rvProfiles.setHasFixedSize(true)

        val gitHubToolbarButton = binding.toolbar.gitHubLogo
        gitHubToolbarButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com"))
            startActivity(intent)
        }

        val searchDeveloperButton = binding.searchDev
        searchDeveloperButton.setOnClickListener{
            val searchIntent = Intent(this@MainActivity,SearchUsers::class.java)
            startActivity(searchIntent)
        }

        list.addAll(ProfilesData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList(){
        rvProfiles.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val listProfileAdapter = ListProfileAdapter(list)
        rvProfiles.adapter = listProfileAdapter
    }

}