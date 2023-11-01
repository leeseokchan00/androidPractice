package com.example.androidpractice

import android.app.Application
import com.example.androidpractice.util.LoginStateObject
import com.example.androidpractice.util.UserDataObject

class MyApplication:Application() {
    companion object{
        lateinit var loginState : LoginStateObject
        lateinit var userdata : UserDataObject
    }

    override fun onCreate() {
        loginState = LoginStateObject(applicationContext)
        userdata = UserDataObject(applicationContext)
        super.onCreate()
    }
}