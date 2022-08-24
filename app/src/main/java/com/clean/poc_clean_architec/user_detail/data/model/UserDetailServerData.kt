package com.clean.poc_clean_architec.user_detail.data.model

import com.google.gson.annotations.SerializedName

data class UserServerData(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("email")
    var userEmail: String? = null,

    @SerializedName("first_name")
    var userFirstName: String = "",

    @SerializedName("last_name")
    var userLastName: String = "",

    @SerializedName("avatar")
    var userAvatar: String = ""
)

data class UserDetailServerRootData(@SerializedName("data") var userServerData: UserServerData?)

