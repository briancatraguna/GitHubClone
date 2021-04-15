package com.dicoding.githubclone.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SettingsModel(
        var username: String? = null,
        var reminder: Boolean = false
) : Parcelable