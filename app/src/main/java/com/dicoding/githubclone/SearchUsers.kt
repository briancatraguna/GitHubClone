package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubclone.databinding.ActivitySearchUsersBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class SearchUsers : AppCompatActivity() {

    private lateinit var binding: ActivitySearchUsersBinding
    private var list = ArrayList<Users>()

    companion object {
        private val TAG = SearchUsers::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener{
            val searchEdtText = binding.editTextSearch.text.toString()
            if (searchEdtText.isEmpty()) return@setOnClickListener
            showLoading(true)
            setListUser(searchEdtText)
            showLoading(false)
            showRecyclerList()
        }
    }

    private fun showRecyclerList() {
        binding.rvUserSearch.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = SearchProfileAdapter()
        listUserAdapter.setData(list)
        binding.rvUserSearch.adapter = listUserAdapter
    }

    private fun setListUser(username: String) {
        val listItems = ArrayList<Users>()
        val token = "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"
        val url = "https://api.github.com/search/users?q=$username"

        val client = AsyncHttpClient()
        client.addHeader("Authorization","token $token")
        client.addHeader("User-Agent","request")
        client.get(url,object: AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                //parsingjson
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val items = responseObject.getJSONArray("items")

                    for (i in 0 until items.length()){
                        val UserClass = Users()
                        val user = items.getJSONObject(i)
                        val username = user.getString("login")
                        val avatar = user.getString("avatar_url")
                        UserClass.login = username
                        UserClass.avatar = avatar
                        listItems.add(UserClass)
                        Log.d("TAG","$username $avatar")
                    }
                    list = listItems
                } catch (e: Exception){
                    Log.d("Exception",e.message.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                Log.d("onFailure",error.message.toString())
            }

        })
    }


    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}