package com.dicoding.githubclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubclone.adapter.SearchProfileAdapter
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.ActivitySearchUsersBinding
import com.dicoding.githubclone.viewmodel.MainViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class SearchUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchUsersBinding
    private lateinit var mainViewModel: MainViewModel
    val listUserAdapter = SearchProfileAdapter()

    companion object {
        private val TAG = SearchUsersActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUserSearch.layoutManager = LinearLayoutManager(this)
        binding.rvUserSearch.adapter = listUserAdapter

        mainViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.btnSearch.setOnClickListener{
            showLoading(true)
            val searchEdtText = binding.editTextSearch.text.toString()
            if (searchEdtText.isEmpty()) return@setOnClickListener
            mainViewModel.setUser(searchEdtText)
        }

        mainViewModel.getUser().observe(this,{userItems ->
            if (userItems!=null){
                listUserAdapter.setData(userItems)
                showLoading(false)
            }
        })

        binding.toolbarSearchPage.backHome.setOnClickListener{
            finish()
        }
    }


    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}