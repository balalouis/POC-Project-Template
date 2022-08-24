package com.clean.poc_clean_architec.registration.domain.repo

import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationResponseModel
import kotlinx.coroutines.flow.Flow

interface RegisterRepo {
    fun register(registrationRequestModel: RegistrationRequestModel): Flow<RegistrationResponseModel>
}