package com.example.androidpractice.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDao {
    @Insert
    fun insertFriend(friend: FriendEntity)

    @Query("select * from friendentity")
    fun getAll():FriendEntity

    @Query("delete from friendentity")
    fun deleteAll()
}
