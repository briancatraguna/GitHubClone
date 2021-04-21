package com.dicoding.githubclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubclone.activity.DetailFavoriteActivity
import com.dicoding.githubclone.activity.DetailUserActivity
import com.dicoding.githubclone.data.FavoriteUser
import com.dicoding.githubclone.database.MappingHelper
import com.dicoding.githubclone.database.UserHelper
import com.dicoding.githubclone.databinding.ItemRowFavoritesBinding

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.UserViewHolder>() {

    private val listFavorite = ArrayList<FavoriteUser>()
    fun setData(items:ArrayList<FavoriteUser>){
        listFavorite.clear()
        listFavorite.addAll(items)
        notifyDataSetChanged()
    }


    class UserViewHolder(private val binding: ItemRowFavoritesBinding) : RecyclerView.ViewHolder(binding.root) {
        val removeButton: ImageView = binding.removeUserButton
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
        holder.removeButton.setOnClickListener{
            val context = holder.removeButton.context
            val username = holder.username.text.toString()
            deleteFromFavorite(context,username)
            setData(getItemList(context))
        }
        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val detailIntent = Intent(context, DetailFavoriteActivity::class.java)
            detailIntent.putExtra(DetailUserActivity.EXTRA_USERNAME,listFavorite[position].username)
            context.startActivity(detailIntent)
        }
    }

    private fun getItemList(context: Context): ArrayList<FavoriteUser>{
        val userHelper = UserHelper.getInstance(context)
        userHelper.open()
        val cursor = userHelper.queryAll()
        val users = MappingHelper.mapCursorToArrayList(cursor)
        userHelper.close()
        return users
    }

    private fun deleteFromFavorite(context:Context,username:String){
        val userHelper = UserHelper.getInstance(context)
        userHelper.open()
        val status = userHelper.deleteByUsername(username)
        userHelper.close()
        if (status>-1){
            Toast.makeText(context,"Removed $username from favorites!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context,"Failed to remove $username from favorites!", Toast.LENGTH_SHORT).show()
        }
    }


}
