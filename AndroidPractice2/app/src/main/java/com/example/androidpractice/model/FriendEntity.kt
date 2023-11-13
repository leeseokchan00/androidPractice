package com.example.androidpractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friend_table")
data class FriendEntity(
    val time: String?,
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String?
) {
    companion object {
        fun toFriendList(friendList: List<FriendData>) = friendList.map { data ->
            FriendEntity(
                time = data.time,
                id = data.id,
                name = data.name,
            )
        }

        fun toFriend(friendInfoList: List<FriendEntity>) = friendInfoList.map { data ->
            FriendData(
                time = data.time,
                id = data.id,
                name = data.name,
            )
        }
    }
}
