package com.clean.poc_clean_architec.domain.repo

import com.clean.poc_clean_architec.data.model.LoginRequestModel
import com.clean.poc_clean_architec.data.model.LoginResponseModel
import com.clean.poc_clean_architec.domain.model.UserUIData
import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    fun login(loginRequestModel: LoginRequestModel): Flow<LoginResponseModel>
}