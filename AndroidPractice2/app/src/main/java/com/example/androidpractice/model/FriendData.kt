package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FriendData(
    val time: String?,
    val id: Int?,
    val name: String?
) : Parcelable {
    companion object {
        fun toFriendEntity(friend: FriendData?): FriendEntity {

            return FriendEntity(
                time = friend?.time,
                id = friend?.id,
                name = friend?.name,
            )
        }
    }
}

