package com.example.androidpractice.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class UserDto(
    val id: String? = "",
    val pw: String? = ""
)

fun toUserDto(user:UserData?): UserDto{
    return UserDto(user?.id, user?.pw)
}

fun encode(user: UserDto?): String {
    return Json.encodeToString(user)
}

fun decode(user: String) {
    Json.decodeFromString<UserDto>(user)
}