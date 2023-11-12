package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FriendData(
    val time: String,
    val id: Int,
    val name: String
) : Parcelable
