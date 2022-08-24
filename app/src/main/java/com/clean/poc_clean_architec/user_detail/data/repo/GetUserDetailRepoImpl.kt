package com.clean.poc_clean_architec.user_detail.data.repo

import com.clean.poc_clean_architec.user_detail.data.mapper.UserDetailMapper
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.user_detail.domain.model.UserUIData
import com.clean.poc_clean_architec.user_detail.domain.repo.GetUserDetailRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetUserDetailRepoImpl @Inject constructor(
    var apiWebService: ApiWebService,
    var userDetailMapper: UserDetailMapper
) : GetUserDetailRepo {

    override fun fetchUserDetail(userId: String): Flow<UserUIData> = flow {
        val userDetailServerRootData = apiWebService.fetchUserDetail(userId)
        val userUIData = userDetailMapper.toUserUIData(userDetailServerRootData.userServerData)
        emit(userUIData)
    }

}