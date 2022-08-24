package com.clean.poc_clean_architec.login.data.repo

import com.clean.poc_clean_architec.login.data.model.LoginRequestModel
import com.clean.poc_clean_architec.login.data.model.LoginResponseModel
import com.clean.poc_clean_architec.login.domain.repo.LoginRepo
import com.clean.poc_clean_architec.network.ApiWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(var apiWebService: ApiWebService) : LoginRepo {
    override fun login(loginRequestModel: LoginRequestModel): Flow<LoginResponseModel> =
        flow {
            val loginResponseModel = apiWebService.loginApiCall(loginRequestModel)
            emit(loginResponseModel)
        }
}