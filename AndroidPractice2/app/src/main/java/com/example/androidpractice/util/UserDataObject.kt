package com.example.androidpractice.util

import android.content.Context

class UserDataObject(context: Context) {
    private val userdata = context.getSharedPreferences("userData", Context.MODE_PRIVATE)

    fun getString(key: String, default: String): String {
        return userdata.getString(key, default).toString()
    }

    fun setString(key: String, value: String) {
        userdata.edit().putString(key, value).apply()
    }
}