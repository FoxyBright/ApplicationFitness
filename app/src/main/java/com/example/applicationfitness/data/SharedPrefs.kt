package com.example.applicationfitness.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.applicationfitness.models.Languages
import com.example.applicationfitness.models.Languages.RU

class SharedPrefs(context: Context) {
    
    private val prefs: SharedPreferences = context
        .getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
    
    companion object {
        
        private const val PREFS_NAME = "prefs"
        
        private const val LOGIN_STATUS_KEY = "isLoginKey"
        private const val LANGUAGE_KEY = "languageKey"
    }
    
    fun getIsLogin() = prefs
        .getBoolean(LOGIN_STATUS_KEY, false)
    
    fun setIsLogin(isLogin: Boolean) = prefs
        .edit().putBoolean(LOGIN_STATUS_KEY, isLogin).apply()
    
    fun setLocalLanguage(languages: Languages) = prefs
        .edit().putString(LANGUAGE_KEY, languages.value).apply()
    
    fun getLocalLanguage() = prefs
        .getString(LANGUAGE_KEY, RU.value)
        .let { Languages.getLanguage(it) }
}