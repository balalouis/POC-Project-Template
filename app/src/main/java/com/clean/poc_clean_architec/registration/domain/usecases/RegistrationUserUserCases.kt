package com.clean.poc_clean_architec.registration.domain.usecases

import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.domain.repo.RegisterRepo
import javax.inject.Inject

class RegistrationUserUserCases @Inject constructor(private var registerRepo: RegisterRepo) {

    fun register(registrationRequestModel: RegistrationRequestModel) = registerRepo.register(registrationRequestModel)

}