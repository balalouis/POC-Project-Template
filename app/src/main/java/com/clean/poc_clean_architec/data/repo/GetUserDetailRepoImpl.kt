package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.mapper.CleanMapper
import com.clean.poc_clean_architec.domain.model.UserUIData
import com.clean.poc_clean_architec.domain.repo.GetUserDetailRepo
import com.clean.poc_clean_architec.network.ApiWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetUserDetailRepoImpl @Inject constructor(
    var apiWebService: ApiWebService,
    var cleanMapper: CleanMapper
) : GetUserDetailRepo {

    override fun fetchUserDetail(userId: String): Flow<UserUIData> = flow {
        val userDetailServerRootData = apiWebService.fetchUserDetail(userId)
        val userUIData = cleanMapper.toUserUIData(userDetailServerRootData.userServerData)
        emit(userUIData)
    }

}