package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.model.LoginRequestModel
import com.clean.poc_clean_architec.data.model.LoginResponseModel
import com.clean.poc_clean_architec.domain.repo.LoginRepo
import com.clean.poc_clean_architec.network.ApiWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepoImpl(var apiWebService: ApiWebService) : LoginRepo {
    override fun login(loginRequestModel: LoginRequestModel): Flow<LoginResponseModel> =
        flow {
            val loginResponseModel = apiWebService.loginApiCall(loginRequestModel)
            emit(loginResponseModel)
        }
}