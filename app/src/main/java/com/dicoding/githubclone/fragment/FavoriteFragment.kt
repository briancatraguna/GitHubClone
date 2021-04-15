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
import com.dicoding.githubclone.adapter.FavoriteAdapter
import com.dicoding.githubclone.adapter.FollowAdapter
import com.dicoding.githubclone.data.FavoriteModelClass
import com.dicoding.githubclone.database.DatabaseHandler
import com.dicoding.githubclone.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var rvFavorites: RecyclerView
    val listUserAdapter = FavoriteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        rvFavorites = binding.rvFavorites
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val githubToolbarButton = binding.toolbar.gitHubLogo
        githubToolbarButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com"))
            startActivity(intent)
        }

        showRecyclerList()

    }

    private fun getItemsList(): ArrayList<FavoriteModelClass>{
        val databaseHandler: DatabaseHandler = this.context?.let { DatabaseHandler(it) }!!
        val favoriteList: ArrayList<FavoriteModelClass> = databaseHandler.viewUserInFavorite()
        return favoriteList
    }

    private fun showRecyclerList() {
        rvFavorites.layoutManager = LinearLayoutManager(activity)
        listUserAdapter.setData(getItemsList())
        rvFavorites.adapter = listUserAdapter
    }
}