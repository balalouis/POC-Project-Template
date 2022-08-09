package com.clean.poc_clean_architec.data.repo

import com.clean.poc_clean_architec.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.data.model.RegistrationResponseModel
import com.clean.poc_clean_architec.domain.repo.RegisterRepo
import com.clean.poc_clean_architec.network.ApiWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterRepoImpl @Inject constructor(var apiWebService: ApiWebService) : RegisterRepo {
    override fun register(registrationRequestModel: RegistrationRequestModel): Flow<RegistrationResponseModel> =
        flow{
            val registerResponseModel=apiWebService.registrationApiCall(registrationRequestModel)
            emit(registerResponseModel)
        }
}