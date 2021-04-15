package com.dicoding.githubclone.preference

import android.content.Context
import com.dicoding.githubclone.data.SettingsModel

internal class SettingsPreference(context: Context){
    companion object{
        private const val PREFS_NAME = "settings_pref"
        private const val USERNAME_KEY = "username"
        private const val REMINDER_KEY = "switch_preference"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)

    fun setSettings(value: SettingsModel){
        val editor = preferences.edit()
        editor.putString(USERNAME_KEY,value.username)
        editor.putBoolean(REMINDER_KEY,value.reminder)
        editor.apply()
    }

    fun getSettings(): SettingsModel{
        val model = SettingsModel()
        model.username = preferences.getString(USERNAME_KEY,"username")
        model.reminder = preferences.getBoolean(REMINDER_KEY,false)
        return model
    }

}