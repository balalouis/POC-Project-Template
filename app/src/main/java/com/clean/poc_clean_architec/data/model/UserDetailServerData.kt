package com.clean.poc_clean_architec.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailServerData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String
)