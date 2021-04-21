package com.dicoding.githubclone.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.sql.SQLException
import kotlin.jvm.Throws

class UserHelper(context: Context) {

    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = DatabaseContract.UserColumns.TABLE_NAME
        private var INSTANCE: UserHelper? = null
        fun getInstance(context: Context): UserHelper =
            INSTANCE?: synchronized(this){
                INSTANCE?:UserHelper(context)
            }
    }

    @Throws(SQLException::class)
    fun open(){
        database = databaseHelper.writableDatabase
    }

    fun close(){
        databaseHelper.close()
        if (database.isOpen){
            database.close()
        }
    }

    fun queryAll(): Cursor{
        database = databaseHelper.readableDatabase
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "${DatabaseContract.UserColumns.KEY_ID} ASC"
        )
    }

    fun queryById(id: String):Cursor{
        return database.query(
            DATABASE_TABLE,
            null,
            "${DatabaseContract.UserColumns.KEY_ID} = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    fun insert(values: ContentValues?): Long{
        return database.insert(DATABASE_TABLE,null,values)
    }

    fun update(id: String, values: ContentValues?): Int{
        return database.update(DATABASE_TABLE,values,"${DatabaseContract.UserColumns.KEY_ID} = ?",
            arrayOf(id))
    }

    fun deleteById(id: String): Int{
        return database.delete(DATABASE_TABLE,"${DatabaseContract.UserColumns.KEY_ID} = ?",null)
    }

    fun deleteByUsername(username: String): Int{
        return database.delete(DATABASE_TABLE,"${DatabaseContract.UserColumns.KEY_USERNAME} = ?",
            arrayOf(username))
    }

}