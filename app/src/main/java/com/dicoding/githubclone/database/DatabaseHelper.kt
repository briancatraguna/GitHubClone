package com.dicoding.githubclone.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

internal class DatabaseHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FavoriteUserDB"

        private const val SQL_CREATE_TABLE_USER = ("CREATE TABLE "+ DatabaseContract.UserColumns.TABLE_NAME +
                "("+ DatabaseContract.UserColumns.KEY_ID +" INTEGER PRIMARY KEY,"+
                DatabaseContract.UserColumns.KEY_USERNAME +" TEXT,"+
                DatabaseContract.UserColumns.KEY_AVATAR +" TEXT"+")")
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.UserColumns.TABLE_NAME}")
        onCreate(db)
    }
}