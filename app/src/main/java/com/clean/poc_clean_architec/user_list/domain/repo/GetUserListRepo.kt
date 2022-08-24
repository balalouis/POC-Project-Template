package com.clean.poc_clean_architec.user_list.domain.repo

import com.clean.poc_clean_architec.user_list.domain.model.UserList


interface GetUserListRepo {
    suspend fun fetchUserList() : UserList
}