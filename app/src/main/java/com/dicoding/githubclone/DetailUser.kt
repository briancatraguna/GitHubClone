package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.databinding.ActivityDetailUserBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var username: String

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra(EXTRA_USERNAME).toString()
        binding.usernameSearchDetail.text = username

        setDetailData()

    }

    private fun setDetailData() {
        val token = "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"
        val url = "https://api.github.com/users/$username"

        val client = AsyncHttpClient()
        client.addHeader("Authorization","token $token")
        client.addHeader("User-Agent","request")
        client.get(url,object:AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    with(binding){
                        Glide.with(applicationContext)
                            .load(responseObject.getString("avatar_url"))
                            .apply(RequestOptions().override(400,400))
                            .into(avatarSearchDetail)
                    }
                    if (responseObject.getString("name")=="null"){
                        binding.fullNameSearchDetail.text = "-"
                    } else {
                        binding.fullNameSearchDetail.text = responseObject.getString("name")
                    }
                    if (responseObject.getString("bio")=="null"){
                        binding.bioSearchDetail.text = "-"
                    } else {
                        binding.bioSearchDetail.text = responseObject.getString("bio")
                    }
                    if (responseObject.getString("company")=="null"){
                        binding.companySearchDetail.text = "-"
                    } else {
                        binding.companySearchDetail.text = responseObject.getString("company")
                    }
                    if (responseObject.getString("location")=="null"){
                        binding.locationSearchDetail.text = "-"
                    } else {
                        binding.locationSearchDetail.text = responseObject.getString("location")
                    }
                    if (responseObject.getString("blog")=="null"){
                        binding.linkSearchDetail.text = "-"
                    } else {
                        binding.linkSearchDetail.text = responseObject.getString("blog")
                    }

                    binding.repoSearchDetail.text = responseObject.getInt("public_repos").toString()
                } catch (e:Exception){
                    Log.d("Exception",e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("onFailure",error.message.toString())
            }

        })
    }

}