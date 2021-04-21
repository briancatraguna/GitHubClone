package com.dicoding.consumerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.consumerapp.databinding.ItemRowFavoritesBinding
import com.dicoding.consumerapp.data.FavoriteUser


class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.UserViewHolder>() {

    private val listFavorite = ArrayList<FavoriteUser>()
    fun setData(items:ArrayList<FavoriteUser>){
        listFavorite.clear()
        listFavorite.addAll(items)
        notifyDataSetChanged()
    }


    class UserViewHolder(private val binding: ItemRowFavoritesBinding) : RecyclerView.ViewHolder(binding.root) {
        val username: TextView = binding.usernameSearch

        fun bind(user: FavoriteUser){
            with(binding){
                Glide.with(itemView.context)
                        .load(user.avatar)
                        .apply(RequestOptions().override(400,400))
                        .into(imgProfilePictureSearch)
                usernameSearch.text = user.username
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRowFavoritesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFavorite.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listFavorite[position])
    }


}
