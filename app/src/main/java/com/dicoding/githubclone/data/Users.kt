package com.dicoding.githubclone.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Users: Parcelable {
    var login: String? = null
    var avatar: String? = null
}