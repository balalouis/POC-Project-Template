package com.clean.poc_clean_architec.user_list.domain.model

import com.clean.poc_clean_architec.user_detail.domain.model.UserUIData


data class UserList(
    var perPage: Int = 0,
    var totalPages: Int = 0,
    var userModelList: List<UserUIData>? = null
)