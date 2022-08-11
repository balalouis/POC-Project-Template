package com.clean.poc_clean_architec.room

import androidx.room.TypeConverter
import com.clean.poc_clean_architec.domain.model.UserUIData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserUIDataTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun userUIDataToString(userUIData: UserUIData): String {
        return gson.toJson(userUIData)
    }

    @TypeConverter
    fun stringToUserUIData(userUIDataString: String): UserUIData {
        val objectType = object : TypeToken<UserUIData>() {}.type
        return gson.fromJson(userUIDataString, objectType)
    }

}

