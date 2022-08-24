package com.clean.poc_clean_architec.login.domain.repo

import com.clean.poc_clean_architec.login.data.model.LoginRequestModel
import com.clean.poc_clean_architec.login.data.model.LoginResponseModel
import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    fun login(loginRequestModel: LoginRequestModel): Flow<LoginResponseModel>
}