package com.clean.poc_clean_architec.domain.usecases

import com.clean.poc_clean_architec.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.domain.repo.RegisterRepo
import javax.inject.Inject

class RegistrationUserUserCases @Inject constructor(private var registerRepo: RegisterRepo) {

    fun register(registrationRequestModel: RegistrationRequestModel) = registerRepo.register(registrationRequestModel)

}