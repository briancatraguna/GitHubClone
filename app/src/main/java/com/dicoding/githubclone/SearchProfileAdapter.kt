package com.dicoding.githubclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubclone.databinding.ItemRowDeveloperProfilesBinding

class SearchProfileAdapter(private val listProfile: ArrayList<String>):RecyclerView.Adapter<SearchProfileAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ItemRowDeveloperProfilesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(username: String){
            with(binding){
                usernameSearch.text = username
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDeveloperProfilesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listProfile[position])
    }

    override fun getItemCount(): Int {
        return listProfile.size
    }
}