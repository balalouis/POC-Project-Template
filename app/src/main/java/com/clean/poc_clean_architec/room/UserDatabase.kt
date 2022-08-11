package com.clean.poc_clean_architec.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.clean.poc_clean_architec.domain.model.UserUIData

@Database(entities = [UserUIData::class], version = 1)
@TypeConverters(UserUIDataTypeConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}