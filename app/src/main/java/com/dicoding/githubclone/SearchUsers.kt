package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubclone.databinding.ActivitySearchUsersBinding

class SearchUsers : AppCompatActivity() {

    private lateinit var binding: ActivitySearchUsersBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter : SearchProfileAdapter

    companion object {
        private val TAG = SearchUsers::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SearchProfileAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.apply {
            rvUserSearch.layoutManager = LinearLayoutManager(this@SearchUsers)
            rvUserSearch.setHasFixedSize(true)
            rvUserSearch.adapter = adapter

            btnSearch.setOnClickListener{

            }
            etQuery.setOnKeyListener { v, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }

    }

    private fun showLoading(state: Boolean){
        if (state)
    }
}