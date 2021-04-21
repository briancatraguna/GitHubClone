package com.dicoding.consumerapp.database

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {

    const val AUTHORITY = "com.dicoding.githubclone"
    const val SCHEME = "content"

    class UserColumns: BaseColumns{
        companion object{
            const val TABLE_NAME = "FavTable"

            const val KEY_ID = "_id" //primary key -> unique for each record
            const val KEY_USERNAME = "username"
            const val KEY_AVATAR = "avatar"

            // untuk membuat URI content
            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}