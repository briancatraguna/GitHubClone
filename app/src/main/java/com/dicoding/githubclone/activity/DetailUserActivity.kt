package com.dicoding.githubclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.R
import com.dicoding.githubclone.adapter.SectionsPagerAdapter
import com.dicoding.githubclone.data.FavoriteModelClass
import com.dicoding.githubclone.database.DatabaseHandler
import com.dicoding.githubclone.databinding.ActivityDetailUserBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var username: String
    private lateinit var avatar: String
    private lateinit var favoriteIcon: ImageView

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra(EXTRA_USERNAME).toString()
        binding.usernameSearchDetail.text = username
        getAvatar()

        setDetailData()

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        sectionsPagerAdapter.username = username
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs,viewPager){tab,position->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        var statusFavorite = getStatusFavorite()
        favoriteIcon = binding.toolbar.buttonFavorite
        setStatusFavorite(statusFavorite)
        favoriteIcon.setOnClickListener{
            statusFavorite = !statusFavorite
            setStatusFavorite(statusFavorite)
            if (statusFavorite == true){
                addToFavorite()
            } else if (statusFavorite == false){
                deleteFromFavorite()
            }
        }
    }

    private fun getStatusFavorite(): Boolean {
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val favoriteList: ArrayList<FavoriteModelClass> = databaseHandler.viewUserInFavorite()
        var usernameCheck : String
        for (item in favoriteList){
            usernameCheck = item.username
            if (usernameCheck == username){
                return true
            }
        }
        return false
    }

    /**
     * Adds to favorite database
     */
    private fun addToFavorite(){
        //initialize the database handler object
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val status = databaseHandler.addUserToFavorite(FavoriteModelClass(0,username,avatar))
        if (status>-1){
            Toast.makeText(this,"Added $username to favorites!",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Failed to add $username to favorites!",Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Deletes user from favorite database
     */
    private fun deleteFromFavorite(){
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        val status = databaseHandler.deleteUserInFavoriteByUsername(username)
        if (status>-1){
            Toast.makeText(this,"Removed $username from favorites!",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Failed to remove $username from favorites!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite){
            favoriteIcon.setImageResource(R.drawable.ic_favorite)
        } else {
            favoriteIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

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
                    showLoading(false)
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

    private fun getAvatar(){
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
                    avatar = responseObject.getString("avatar_url")
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

    private fun showLoading(state: Boolean){
        if (state){
            binding.progressBarDetail.visibility = View.VISIBLE
        } else {
            binding.progressBarDetail.visibility = View.GONE
        }
    }

}