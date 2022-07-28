package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.mapper.MyMapper
import com.clean.poc_clean_architec.domain.model.UserList
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import com.clean.poc_clean_architec.network.ApiWebService
import javax.inject.Inject


class GetUserListRepoImpl @Inject constructor(
    var apiWebService: ApiWebService,
    var myMapper: MyMapper
) : GetUserListRepo {
    override suspend fun fetchUserList(): UserList {
        return myMapper.toUserList(apiWebService.fetchUserListDummy())
    }
}