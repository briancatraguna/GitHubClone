package com.dicoding.githubclone.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.R
import com.dicoding.githubclone.activity.DetailUserActivity
import com.dicoding.githubclone.data.Users
import com.dicoding.githubclone.databinding.ItemRowDeveloperProfilesBinding

class SearchProfileAdapter: RecyclerView.Adapter<SearchProfileAdapter.UserViewHolder>() {

    private val list = ArrayList<Users>()
    fun setData(items:ArrayList<Users>){
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
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
        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val detailIntent = Intent(context, DetailUserActivity::class.java)
            detailIntent.putExtra(DetailUserActivity.EXTRA_USERNAME,list[position].login)
            context.startActivity(detailIntent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}