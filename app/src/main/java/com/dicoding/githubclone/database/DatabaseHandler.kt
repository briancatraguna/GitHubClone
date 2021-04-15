package com.dicoding.githubclone.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.dicoding.githubclone.data.FavoriteModelClass

class DatabaseHandler(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FavoriteUserDB"
        private const val TABLE_NAME = "FavTable"

        private const val KEY_ID = "_id" //primary key -> unique for each record
        private const val KEY_USERNAME = "username"
        private const val KEY_AVATAR = "avatar"
    }

    //onCreate is called once the database is created
    override fun onCreate(db: SQLiteDatabase?) {
        //creating table with fields -> using SQL command
        val CREATE_USER_TABLE = ("CREATE TABLE "+ TABLE_NAME+
                "("+ KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_USERNAME+" TEXT,"+
                KEY_AVATAR+" TEXT"+")")
        //execute the SQL command
        db?.execSQL(CREATE_USER_TABLE)
    }

    //onUpgrade is called when we upgrade our table
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME)
        onCreate(db)
    }

    /**
     * Adds to database: CREATE
     */
    fun addUserToFavorite(user: FavoriteModelClass): Long{
        //initialize the database that we want to write on
        val db = this.writableDatabase
        //contentValues carry the data that we want to put in the database
        val contentValues = ContentValues()
        //id is unecessary as it will automatically increment
        contentValues.put(KEY_USERNAME,user.username) //putting the username
        contentValues.put(KEY_AVATAR,user.avatar)
        //success will return a long value
        val success = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return success
    }

    /**
     * Reading the data in database. Returns the user object: READ
     */
    fun viewUserInFavorite(): ArrayList<FavoriteModelClass>{
        val userList: ArrayList<FavoriteModelClass> = ArrayList<FavoriteModelClass>()
        //selects ALL data, SQL command. Give me everything in the table!
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        //initialize the database that we want to read on
        val db = this.readableDatabase
        //A SQL cursor retrieves data one row at a time
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery,null)
        } catch (e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }

        //make variables to store data
        var id: Int
        var username: String
        var avatar: String

        //cursor moves to each entry one by one and retrieves data
        if (cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                username = cursor.getString(cursor.getColumnIndex(KEY_USERNAME))
                avatar = cursor.getString(cursor.getColumnIndex(KEY_AVATAR))
                val user = FavoriteModelClass(id = id,username = username,avatar = avatar)
                userList.add(user)
            } while (cursor.moveToNext())
        }
        return userList
    }

    /**
     * Deletes a user from favorite: DELETE
     */
    fun deleteUserInFavoriteByUsername(username: String): Int{
        //initialize the database that we want to delete on
        val db = this.writableDatabase
        //setup the container to show which user we want to delete
        val contentValues = ContentValues()
        contentValues.put(KEY_USERNAME,username)
        //Deleting Row where user is that
        val success = db.delete(TABLE_NAME, "$KEY_USERNAME=?", arrayOf(username))
        db.close()
        return success
    }

}