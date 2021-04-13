package com.dicoding.githubclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.ItemRowDeveloperProfilesBinding

class FollowAdapter: RecyclerView.Adapter<FollowAdapter.UserViewHolder>(){

    private val listFollowing = ArrayList<Users>()
    fun setData(items:ArrayList<Users>){
        listFollowing.clear()
        listFollowing.addAll(items)
        notifyDataSetChanged()
    }

    class UserViewHolder(private val binding:ItemRowDeveloperProfilesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user:Users){
            with(binding){
                Glide.with(itemView.context)
                        .load(user.avatar)
                        .apply(RequestOptions().override(400,400))
                        .into(imgProfilePictureSearch)
                usernameSearch.text = user.login
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRowDeveloperProfilesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listFollowing[position])
    }

    override fun getItemCount(): Int {
        return listFollowing.size
    }


}