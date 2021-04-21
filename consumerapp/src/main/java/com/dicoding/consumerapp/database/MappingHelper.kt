package com.dicoding.consumerapp.database

import android.database.Cursor
import com.dicoding.consumerapp.data.FavoriteUser

object MappingHelper {

    fun mapCursorToArrayList(userCursor: Cursor?): ArrayList<FavoriteUser>{
        val favUserList = ArrayList<FavoriteUser>()

        userCursor?.apply {
            while (moveToNext()){
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.UserColumns.KEY_ID))
                val username = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.KEY_USERNAME))
                val avatar = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.KEY_AVATAR))
                val favUser = FavoriteUser(id,username,avatar)
                favUserList.add(favUser)
            }
        }
        return favUserList
    }

}