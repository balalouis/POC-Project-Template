package com.clean.poc_clean_architec.data.mapper

import com.clean.poc_clean_architec.data.model.UserListServerData
import com.clean.poc_clean_architec.data.model.UserServerData
import com.clean.poc_clean_architec.domain.model.UserList
import com.clean.poc_clean_architec.domain.model.UserUIData
import javax.inject.Inject

class CleanMapper @Inject constructor() {

    fun toUserList(userListServerData: UserListServerData): UserList {
        return UserList(
            perPage = userListServerData.perPage,
            totalPages = userListServerData.totalPages,
            userModelList = convertToUserList(userListServerData.userModelList!!)
        )
    }

    fun toUserUIData(userServerData: UserServerData?): UserUIData {
        return UserUIData(
            id = userServerData!!.id,
            userEmail = userServerData.userEmail,
            userFirstName = userServerData.userFirstName,
            userLastName = userServerData.userLastName,
            userAvatar = userServerData.userAvatar
        )
    }

    private fun convertToUserList(userListServerData: List<UserServerData>): List<UserUIData> {
        val listUser: MutableList<UserUIData> = mutableListOf()
        for (userServerData in userListServerData) {
            listUser.add(toUserUIData(userServerData))
        }
        return listUser.toList()
    }
}