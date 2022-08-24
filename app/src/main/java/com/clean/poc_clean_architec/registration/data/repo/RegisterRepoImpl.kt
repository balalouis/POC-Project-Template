package com.clean.poc_clean_architec.registration.data.repo

import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationResponseModel
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.registration.domain.repo.RegisterRepo
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