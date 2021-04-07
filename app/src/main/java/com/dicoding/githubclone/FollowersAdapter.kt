package com.dicoding.githubclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.ItemRowDeveloperProfilesBinding

class FollowersAdapter: RecyclerView.Adapter<FollowersAdapter.UserViewHolder>() {

    private val list = ArrayList<Users>()
    fun setData(items:ArrayList<Users>){
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowDeveloperProfilesBinding.bind(itemView)
        fun bind(userItems: Users){
            with(itemView){
                binding.usernameSearch.text = userItems.login
            }
            with(binding){
                Glide.with(itemView.context)
                        .load(userItems.avatar)
                        .apply(RequestOptions().override(400,400))
                        .into(imgProfilePictureSearch)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_row_developer_profiles,parent,false)
        return UserViewHolder(mView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}