package com.example.androidpractice.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: String? = "",
    val pw: String? = ""
)

fun toUserDto(user: UserData?): UserDto {
    return UserDto(user?.id, user?.pw)
}

fun toUser(user: UserDto): UserData {
    return UserData(user.id, user.pw)
}