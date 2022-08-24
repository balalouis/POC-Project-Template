package com.clean.poc_clean_architec.user_list.data.model

import com.clean.poc_clean_architec.user_detail.data.model.UserServerData
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


