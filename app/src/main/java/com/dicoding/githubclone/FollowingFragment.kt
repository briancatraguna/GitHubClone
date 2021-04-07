package com.dicoding.githubclone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.FragmentFollowersBinding
import com.dicoding.githubclone.databinding.FragmentFollowingBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class FollowingFragment : Fragment() {

    private lateinit var binding: FragmentFollowingBinding
    private var list = ArrayList<Users>()
    private var layoutManager: RecyclerView.LayoutManager? = null

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
        binding.rvFollowing.setHasFixedSize(true)
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
        return view
    }

    private fun showRecyclerList() {
        binding.rvFollowing.layoutManager = LinearLayoutManager(activity)
        val listUserAdapter = FollowingAdapter(list)
        binding.rvFollowing.adapter = listUserAdapter
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
}