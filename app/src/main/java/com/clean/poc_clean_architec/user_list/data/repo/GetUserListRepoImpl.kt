package com.clean.poc_clean_architec.user_list.data.repo

import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.user_list.data.mapper.UserListMapper
import com.clean.poc_clean_architec.user_list.domain.model.UserList
import com.clean.poc_clean_architec.user_list.domain.repo.GetUserListRepo
import javax.inject.Inject


class GetUserListRepoImpl @Inject constructor(
    var apiWebService: ApiWebService,
    var userListMapper: UserListMapper
) : GetUserListRepo {
    override suspend fun fetchUserList(): UserList {
        return userListMapper.toUserList(apiWebService.fetchUserList())
    }
}