package com.clean.poc_clean_architec.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class UserList(
    var perPage: Int = 0,
    var totalPages: Int = 0,
    var userModelList: List<UserUIData>? = null
)


@Entity(tableName = "user_table")
data class UserUIData(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo("email")
    var userEmail: String? = null,

    @ColumnInfo("first_name")
    var userFirstName: String = "",

    @ColumnInfo("last_name")
    var userLastName: String = "",

    @ColumnInfo("user_avatar")
    var userAvatar: String = ""
)

sealed class UserUIState {
    data class Success(var userList: List<UserUIData>?) : UserUIState()
    data class Failure(var exception: Throwable) : UserUIState()
}

sealed class UserDetailUIState {
    data class Success(var user: UserUIData?) : UserDetailUIState()
    data class Failure(var exception: Throwable) : UserDetailUIState()
}