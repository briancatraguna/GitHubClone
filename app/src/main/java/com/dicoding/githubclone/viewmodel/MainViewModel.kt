package com.dicoding.githubclone.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.githubclone.data.Users
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.lang.Exception

class MainViewModel: ViewModel() {
    val listUsers = MutableLiveData<ArrayList<Users>>()
    //Setter
    fun setUser(username:String){
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
                    listUsers.postValue(listItems)
                } catch (e: Exception){
                    Log.d("Exception",e.message.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                Log.d("onFailure",error.message.toString())
            }

        })
    }
    //getter
    fun getUser():LiveData<ArrayList<Users>>{
        return listUsers
    }
}