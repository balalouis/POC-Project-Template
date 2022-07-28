package com.clean.poc_clean_architec.domain.repo

import com.clean.poc_clean_architec.domain.model.UserList

interface GetUserListRepo {
    suspend fun fetchUserList() : UserList
}