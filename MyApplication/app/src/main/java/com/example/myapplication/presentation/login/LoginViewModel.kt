package com.example.myapplication.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginState: MutableLiveData<Boolean> = MutableLiveData(false)
    val loginState: LiveData<Boolean> = _loginState

    var id: MutableLiveData<String> = MutableLiveData()
    val pw: MutableLiveData<String> = MutableLiveData()

    fun setAccount(ID:String, PW:String){
        id.value = ID
        pw.value = PW
    }
}

