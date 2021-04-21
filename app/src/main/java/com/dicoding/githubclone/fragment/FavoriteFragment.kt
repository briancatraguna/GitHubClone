package com.dicoding.githubclone.fragment

import android.content.Intent
import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.adapter.FavoriteAdapter
import com.dicoding.githubclone.data.FavoriteUser
import com.dicoding.githubclone.database.DatabaseContract
import com.dicoding.githubclone.database.MappingHelper
import com.dicoding.githubclone.database.UserHelper
import com.dicoding.githubclone.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var rvFavorites: RecyclerView
    val listUserAdapter = FavoriteAdapter()
    private var contentResolver = activity?.contentResolver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        val myObserver = object: ContentObserver(handler){
            override fun onChange(selfChange: Boolean) {
                showRecyclerList()
            }
        }
        contentResolver?.registerContentObserver(DatabaseContract.UserColumns.CONTENT_URI,true,myObserver)

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

    private fun getItemsList(): ArrayList<FavoriteUser>{
        val userHelper = UserHelper.getInstance(requireContext())
        userHelper.open()
        val cursor = userHelper.queryAll()
        val users = MappingHelper.mapCursorToArrayList(cursor)
        userHelper.close()
        return users
    }

    private fun showRecyclerList() {
        rvFavorites.layoutManager = LinearLayoutManager(activity)
        listUserAdapter.setData(getItemsList())
        rvFavorites.adapter = listUserAdapter
    }
}