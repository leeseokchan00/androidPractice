package com.example.androidpractice.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDao {
    @Insert
    suspend fun insertFriend(friend: FriendEntity)

    @Query("select * from friend_table")
    suspend fun getAll(): List<FriendEntity>

    @Query("delete from friend_table where id = :id")
    suspend fun delete(id: Int?)

    @Query("delete from friend_table")
    suspend fun deleteAll()
}