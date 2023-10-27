package com.example.mvvmpractice.presentation

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _login: MutableLiveData<Boolean> = MutableLiveData(false)
    val login: LiveData<Boolean> = _login

    // LiveData는 추상클래스, immutable이다. 그래서 mutable하게 만들어 주는 것이 MutableLiveData 이다.
    // LiveData는 immutable해서 thread-safe하지만 값을 변경할 수 없어 MutableLiveData를 통해 값 변경
    lateinit var resultLauncher: ActivityResultLauncher<Intent>


    fun loginStatus(login: Boolean) {
        _login.value = login
    }
    //액티비티에서 호출해서 _currentName의 값을 바꿔줌


}