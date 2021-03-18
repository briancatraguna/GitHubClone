package com.dicoding.githubclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListProfileAdapter(private val listProfile: ArrayList<Profiles>):RecyclerView.Adapter<ListProfileAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvFullName: TextView = itemView.findViewById(R.id.full_name)
        var tvUsername: TextView = itemView.findViewById(R.id.username)
        var tvBio: TextView = itemView.findViewById(R.id.bio)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_profile_picture)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_github_profiles,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProfile.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val profile = listProfile[position]

        holder.imgPhoto.setImageResource(profile.profilePicture)
        holder.tvFullName.text = profile.fullName
        holder.tvUsername.text = profile.username
        holder.tvBio.text = profile.bio

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val detailIntent: Intent = Intent(context,ProfilePage::class.java)
            detailIntent.putExtra(ProfilePage.EXTRA_FULL_NAME,profile.fullName)
            detailIntent.putExtra(ProfilePage.EXTRA_USERNAME,profile.username)
            detailIntent.putExtra(ProfilePage.EXTRA_BIO,profile.bio)
            detailIntent.putExtra(ProfilePage.EXTRA_PICTURE,profile.profilePicture)

            context.startActivity(detailIntent)
        }
    }
}