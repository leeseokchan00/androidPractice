package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Parcelize
data class UserData(
    val id: String? = "",
    val pw: String? = ""
) : Parcelable
