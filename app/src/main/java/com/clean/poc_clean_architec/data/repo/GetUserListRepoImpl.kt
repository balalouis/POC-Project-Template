package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.mapper.CleanMapper
import com.clean.poc_clean_architec.domain.model.UserUIData
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetUserListRepoImpl @Inject constructor(
    var userDao: UserDao,
    var apiWebService: ApiWebService,
    var cleanMapper: CleanMapper
) : GetUserListRepo {
    override suspend fun fetchUserList(): Flow<List<UserUIData>> {
        val userList = cleanMapper.toUserList(apiWebService.fetchUserList())
        userDao.insertUserList(userList.userModelList)
        return userDao.getAllUserUIData()
    }
}