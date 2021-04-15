package com.dicoding.githubclone.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProfileSearchDataClass (
    var username: String?,
    var bio: String?,
        ) : Parcelable