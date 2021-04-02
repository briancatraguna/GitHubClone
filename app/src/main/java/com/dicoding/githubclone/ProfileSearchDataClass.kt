package com.dicoding.githubclone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ProfileSearchDataClass (
    var fullName: String?,
    var username: String?,
    var bio: String?,
    var profilePicture: Int?,
    var followers: Int?,
    var following: Int?,
    var company: String?,
    var blog: String?,
    var email: String?,
    var location: String?
        ) : Parcelable