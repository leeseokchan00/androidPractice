package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val id: String? = "",
    val pw: String? = ""
) : Parcelable
