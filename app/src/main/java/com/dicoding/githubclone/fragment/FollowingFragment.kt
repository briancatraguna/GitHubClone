package com.dicoding.githubclone.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.adapter.FollowAdapter
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.FragmentFollowingBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import java.lang.Exception

class FollowingFragment : Fragment() {

    private lateinit var binding: FragmentFollowingBinding
    private lateinit var rvFollowing : RecyclerView
    val listUserAdapter = FollowAdapter()

    companion object {
        private val ARG_USERNAME = "extra_username"

        fun newInstance(username:String):Fragment{
            var fragment = FollowingFragment()
            val bundle = Bundle()
            bundle.putString(ARG_USERNAME,username)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString(ARG_USERNAME)
        setListUser(username)
        rvFollowing.setHasFixedSize(true)
        showRecyclerList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(inflater,container,false)
        val view: View = binding.root
        rvFollowing = binding.rvFollowing
        return view
    }

    private fun showRecyclerList() {
        rvFollowing.layoutManager = LinearLayoutManager(activity)
        rvFollowing.adapter = listUserAdapter
    }

    private fun setListUser(username: String?) {
        val listItems = ArrayList<Users>()
        val token = "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"
        val url = "https://api.github.com/users/$username/following"

        val client = AsyncHttpClient()
        client.addHeader("Authorization","token $token")
        client.addHeader("User-Agent","request")
        client.get(url,object: AsyncHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                //parsingjson
                try {
                    val result = String(responseBody)
                    val items = JSONArray(result)

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
                    listUserAdapter.setData(listItems)
                } catch (e: Exception){
                    Log.d("Exception",e.message.toString())
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                Log.d("onFailure",error.message.toString())
            }

        })
    }
}