package com.example.sunnzaraa.utils

import android.content.Context

object PrefHelper {
    private const val PREF_NAME = "user_prefs"
    private const val KEY_REMEMBER = "remember"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"

    fun isRemembered(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getBoolean(KEY_REMEMBER, false)
    }

    fun saveLogin(context: Context, email: String, password: String, remember: Boolean){
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        prefs.putBoolean(KEY_REMEMBER, remember)
        prefs.putString(KEY_EMAIL, email)
        prefs.putString(KEY_PASSWORD, password)
        prefs.apply()
    }

    fun clearLogin(context: Context){
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().clear().apply()
    }

    fun getSavedEmail(context: Context): String?{
        return context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE).getString(KEY_PASSWORD, null)
    }

    fun getSavedPassword(context: Context): String? {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(KEY_PASSWORD, null)
    }

}