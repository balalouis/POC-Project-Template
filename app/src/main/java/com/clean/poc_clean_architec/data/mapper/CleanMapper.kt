package com.clean.poc_clean_architec.data.mapper

import com.clean.poc_clean_architec.data.model.UserListServerData
import com.clean.poc_clean_architec.data.model.UserServerData
import com.clean.poc_clean_architec.domain.model.User
import com.clean.poc_clean_architec.domain.model.UserList
import javax.inject.Inject

class CleanMapper @Inject constructor() {

    fun toUserList(userListServerData: UserListServerData): UserList {
        return UserList(
            perPage = userListServerData.perPage,
            totalPages = userListServerData.totalPages,
            userModelList = convertToUserList(userListServerData.userModelList!!)
        )
    }

    private fun toUser(userServerData: UserServerData): User {
        return User(
            userEmail = userServerData.userEmail,
            userFirstName = userServerData.userFirstName,
            userLastName = userServerData.userLastName,
            userAvatar = userServerData.userAvatar
        )
    }

    private fun convertToUserList(userListServerData: List<UserServerData>): List<User> {
        val listUser: MutableList<User> = mutableListOf()
        for (user in userListServerData) {
            listUser.add(toUser(user))
        }
        return listUser.toList()
    }
}