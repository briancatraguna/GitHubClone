package com.dicoding.githubclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.ItemRowDeveloperProfilesBinding

class FollowingAdapter(private val listFollowing: ArrayList<Users>): RecyclerView.Adapter<FollowingAdapter.UserViewHolder>() {
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