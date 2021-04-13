package com.dicoding.githubclone.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.R
import com.dicoding.githubclone.activity.MainActivity
import com.dicoding.githubclone.activity.SearchUsersActivity
import com.dicoding.githubclone.adapter.ListProfileAdapter
import com.dicoding.githubclone.data.Profiles
import com.dicoding.githubclone.databinding.ActivityMainBinding
import com.dicoding.githubclone.databinding.FragmentHomeBinding
import com.dicoding.githubclone.localdata.ProfilesData

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvProfiles: RecyclerView
    private var list: ArrayList<Profiles> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        rvProfiles = binding.rvGithubProfiles
        rvProfiles.setHasFixedSize(true)

        val githubToolbarButton = binding.toolbar.gitHubLogo
        githubToolbarButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com"))
            startActivity(intent)
        }

        val searchDeveloperButton = binding.searchDev
        searchDeveloperButton.setOnClickListener{
            val searchIntent = Intent(context, SearchUsersActivity::class.java)
            startActivity(searchIntent)
        }

        list.addAll(ProfilesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvProfiles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        val listProfileAdapter = ListProfileAdapter(list)
        rvProfiles.adapter = listProfileAdapter
    }

}