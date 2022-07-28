package com.clean.poc_clean_architec.data.mapper

import com.clean.poc_clean_architec.data.model.UserListServer
import com.clean.poc_clean_architec.domain.model.UserList

class MyMapper {
    fun toUserList(userListServer: UserListServer): UserList {
        return UserList(
            perPage = userListServer.perPage,
            totalPages = userListServer.totalPages
        )
    }
}