package com.example.androidpractice.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidpractice.MyApplication
import com.example.androidpractice.model.UserData
import com.google.gson.Gson

class LoginViewModel : ViewModel() {
    private val _loginState: MutableLiveData<Boolean> = MutableLiveData(false)
    val loginState: LiveData<Boolean> = _loginState

    fun loginStateChange() {
        if (MyApplication.loginState.getBoolean("true", false)) {
            _loginState.value = true
        }
    }

    fun setUserData(user: UserData?) {
        val serial = Gson().toJson(user) // 수정해야됨
        MyApplication.userdata.setString("user", serial)
    }

    fun getUserData(id: String, pw: String): Boolean {
        val touser = MyApplication.userdata.getString("user", "null") // 수정
        val user = Gson().fromJson(touser, UserData::class.java)  //수정

        if (id == user.id && pw == user.pw) {
            MyApplication.loginState.setBoolean("true", true)
            loginStateChange()
            return true
        }
        return false
    }
}