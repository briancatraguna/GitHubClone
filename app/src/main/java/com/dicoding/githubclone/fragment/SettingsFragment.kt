package com.dicoding.githubclone.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.dicoding.githubclone.R
import com.dicoding.githubclone.data.SettingsModel
import com.dicoding.githubclone.preference.SettingsPreference
import com.dicoding.githubclone.receiver.AlarmReceiver

class SettingsFragment: PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {
    //key
    private lateinit var USERNAME: String
    private lateinit var LANGUAGE: String
    private lateinit var REMINDER: String

    //value
    private lateinit var usernamePreference: EditTextPreference
    private lateinit var languageSettings: Preference
    private lateinit var reminderPreference: SwitchPreference

    //model and receiver
    private lateinit var settings: SettingsModel
    private lateinit var alarmReceiver: AlarmReceiver
    private lateinit var fragmentContext: Context

    companion object {
        private const val DEFAULT_VALUE = "None"
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        setSummaries()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun setSummaries() {
        val sh = preferenceManager.sharedPreferences
        usernamePreference.summary = sh.getString(USERNAME, DEFAULT_VALUE)
    }

    private fun init(){
        USERNAME = resources.getString(R.string.key_username)
        usernamePreference = findPreference<EditTextPreference>(USERNAME) as EditTextPreference

        LANGUAGE = resources.getString(R.string.language)
        languageSettings = findPreference<Preference>(LANGUAGE) as Preference

        REMINDER = resources.getString(R.string.switch_preference)
        reminderPreference = findPreference<SwitchPreference>(REMINDER) as SwitchPreference

        fragmentContext = activity?.applicationContext!!
        val settingsPreference = SettingsPreference(fragmentContext)
        if (settingsPreference.getSettings().reminder){
            reminderPreference.isChecked = true
        } else {
            reminderPreference.isChecked = false
        }

        alarmReceiver = AlarmReceiver()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        if (key == USERNAME){
            val username = sharedPreferences.getString(USERNAME, DEFAULT_VALUE)
            usernamePreference.summary = username
        }
        if (reminderPreference.isChecked){
            saveReminder(true,sharedPreferences)
            alarmReceiver.setRepeatingAlarm(fragmentContext,"RepeatingAlarm","01:20","Github reminder")
        } else {
            saveReminder(false,sharedPreferences)
            alarmReceiver.cancelAlarm(fragmentContext)
        }
    }

    private fun saveReminder(state: Boolean,sharedPreferences: SharedPreferences) {
        val settingsPreference = SettingsPreference(fragmentContext)
        settings = SettingsModel()
        settings.reminder = state
        settings.username = sharedPreferences.getString(USERNAME,DEFAULT_VALUE)
        settingsPreference.setSettings(settings)
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        if (preference?.key == LANGUAGE){
            val intent = Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }
        return super.onPreferenceTreeClick(preference)
    }


}