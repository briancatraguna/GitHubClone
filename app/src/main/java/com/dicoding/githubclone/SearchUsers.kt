package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.githubclone.databinding.ActivitySearchUsersBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class SearchUsers : AppCompatActivity() {

    private lateinit var binding: ActivitySearchUsersBinding

    companion object {
        private val TAG = SearchUsers::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backToMainActivityFromSearch = binding.toolbarSearchPage.backToMain
        backToMainActivityFromSearch.setOnClickListener{
            finish()
        }

        getDevelopersData()

    }

    private fun getDevelopersData() {
        val asyncClient = AsyncHttpClient()
        asyncClient.addHeader("Authorization","token  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")
        asyncClient.addHeader("User-Agent","request")
        asyncClient.get("https://api.github.com/users/briancatraguna",object : TextHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                val result = responseString
                try {
                    val responseObject = JSONObject(result)
                    val username = responseObject.getString("login")
                    Log.d(TAG,"Connection Succesful.. Name: $username")
                } catch (e:Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                Log.d(TAG,"Connection Failed")
            }
        })
    }
}