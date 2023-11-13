package com.example.androidpractice.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FriendEntity::class], version = 1)
abstract class FriendDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDao
}


