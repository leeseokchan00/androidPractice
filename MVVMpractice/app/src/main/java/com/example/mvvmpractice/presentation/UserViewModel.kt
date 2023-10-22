package com.example.mvvmpractice.presentation

import androidx.lifecycle.ViewModel
//View Model
class UserViewModel: ViewModel() {
    var user: User = User("이석찬", 24)
    //view model은 model 연결
}