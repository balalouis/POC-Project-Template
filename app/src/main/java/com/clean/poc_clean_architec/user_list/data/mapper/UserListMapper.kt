package com.clean.poc_clean_architec.user_list.data.mapper

import com.clean.poc_clean_architec.user_list.data.model.UserListServerData
import com.clean.poc_clean_architec.user_list.domain.model.UserList
import com.clean.poc_clean_architec.user_detail.data.mapper.UserDetailMapper
import com.clean.poc_clean_architec.user_detail.data.model.UserServerData
import com.clean.poc_clean_architec.user_detail.domain.model.UserUIData
import javax.inject.Inject

class UserListMapper @Inject constructor() {

    fun toUserList(userListServerData: UserListServerData): UserList {
        return UserList(
            perPage = userListServerData.perPage,
            totalPages = userListServerData.totalPages,
            userModelList = convertToUserList(userListServerData.userModelList!!)
        )
    }

    private fun convertToUserList(userListServerData: List<UserServerData>): List<UserUIData> {
        val listUser: MutableList<UserUIData> = mutableListOf()
        for (userServerData in userListServerData) {
            listUser.add(UserDetailMapper().toUserUIData(userServerData))
        }
        return listUser.toList()
    }
}