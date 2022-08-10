package com.clean.poc_clean_architec.room

import androidx.room.*
import com.clean.poc_clean_architec.data.model.UserServerData
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserServerData(UserServerData: UserServerData?)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUserServerDataList(UserServerData: List<UserServerData>?)

    @Delete
    suspend fun deleteUserServerDataByModel(UserServerData: UserServerData)

    @Query("DELETE FROM user_table WHERE id = :id")
    suspend fun deleteUserServerDataByID(id: Int)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUserServerData()

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun findUserServerDataById(id: Int): Flow<UserServerData>

    @Query("SELECT * FROM user_table WHERE first_name LIKE :firstName AND " + "last_name LIKE :lastName LIMIT 1")
    fun findUserServerDataByName(firstName: String, lastName: String): Flow<UserServerData>

    @Query("SELECT * FROM user_table")
    fun getAllUserServerData(): Flow<List<UserServerData>>

}