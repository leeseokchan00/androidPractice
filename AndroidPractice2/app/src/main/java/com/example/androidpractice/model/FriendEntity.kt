package com.example.androidpractice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FriendEntity(
    @ColumnInfo val time: String,
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String
)
