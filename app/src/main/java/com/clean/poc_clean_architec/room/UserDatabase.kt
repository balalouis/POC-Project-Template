package com.clean.poc_clean_architec.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clean.poc_clean_architec.data.model.UserServerData

@Database(entities = [UserServerData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}