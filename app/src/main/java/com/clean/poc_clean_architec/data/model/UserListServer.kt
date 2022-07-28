package com.clean.poc_clean_architec.data.model

import com.google.gson.annotations.SerializedName

data class UserListServer(
    @SerializedName("page")
    var page: Int = 2,

    @SerializedName("per_page")
    var perPage: Int = 0,

    @SerializedName("total")
    var total: Int = 0,

    @SerializedName("total_pages")
    var totalPages: Int = 0,

)