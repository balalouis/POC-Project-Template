package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.domain.model.UserList
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import com.clean.poc_clean_architec.network.ApiWebService


class GetUserListRepoImpl(var apiWebService: ApiWebService) : GetUserListRepo {
    override suspend fun fetchUserList(): UserList {
        return apiWebService.fetchUserListDummy()
    }
}