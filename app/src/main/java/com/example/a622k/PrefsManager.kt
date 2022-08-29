package com.example.a622k

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    private val sharedPreferences: SharedPreferences?

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    }

    fun saveData(key: Int, value: String) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key.toString(), value)
        prefsEditor.apply()
    }

    fun getData(key: Int?): String {
        return sharedPreferences?.getString(key.toString(), "") ?: "0"
    }
}