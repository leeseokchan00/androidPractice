package com.example.myapplication.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    private val _signupState: MutableLiveData<Boolean> = MutableLiveData(false)
    val signupState: LiveData<Boolean> = _signupState

    fun signup(id:String, pw:String, state:Boolean){
        _signupState.value = true


    }
}