package com.clean.poc_clean_architec.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UserListServerData(
    @SerializedName("page")
    var page: Int = 2,

    @SerializedName("per_page")
    var perPage: Int = 0,

    @SerializedName("total")
    var total: Int = 0,

    @SerializedName("total_pages")
    var totalPages: Int = 0,

    @SerializedName("data")
    var userModelList: List<UserServerData>? = null
)


@Entity(tableName = "user_table")
data class UserServerData(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    var userEmail: String? = null,

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    var userFirstName: String = "",

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    var userLastName: String = "",

    @ColumnInfo(name = "avatar")
    @SerializedName("avatar")
    var userAvatar: String = ""
)

data class UserDetailServerRootData(@SerializedName("data") var userServerData: UserServerData?)

