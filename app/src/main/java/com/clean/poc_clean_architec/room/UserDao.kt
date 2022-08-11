package com.clean.poc_clean_architec.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clean.poc_clean_architec.domain.model.UserUIData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserUIData(userUIData: UserUIData)

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUserById(id: Int): Flow<UserUIData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserList(user: List<UserUIData>?)

    @Query("SELECT * FROM user_table")
    fun getAllUserUIData(): Flow<List<UserUIData>>
}