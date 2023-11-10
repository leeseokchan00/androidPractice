package com.example.androidpractice.util.sharedpreferences

import android.content.Context

class LoginStateObject(context: Context) {
    private val loginState = context.getSharedPreferences("loginState", Context.MODE_PRIVATE)

    fun getBoolean(key: String, default: Boolean): Boolean {
        return loginState.getBoolean(key, default)
    }

    fun setBoolean(key: String, value: Boolean) {
        loginState.edit().putBoolean(key, value).apply()
    }
}