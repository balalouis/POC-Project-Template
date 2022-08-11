package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.mapper.CleanMapper
import com.clean.poc_clean_architec.domain.model.UserUIData
import com.clean.poc_clean_architec.domain.repo.GetUserDetailRepo
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetUserDetailRepoImpl @Inject constructor(
    var userDao: UserDao,
    var apiWebService: ApiWebService,
    var cleanMapper: CleanMapper
) : GetUserDetailRepo {

    override suspend fun fetchUserDetail(userId: String): Flow<UserUIData> {
        val userDetailServerRootData = apiWebService.fetchUserDetail(userId)
        val userUIData = cleanMapper.toUserUIData(userDetailServerRootData.userServerData)
        userDao.insertUserUIData(userUIData)
        return userDao.getUserById(userId.toInt())
    }

}