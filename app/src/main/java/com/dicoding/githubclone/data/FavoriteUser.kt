package com.dicoding.githubclone.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoriteUser(val id: Int, val username: String,val avatar: String): Parcelable

