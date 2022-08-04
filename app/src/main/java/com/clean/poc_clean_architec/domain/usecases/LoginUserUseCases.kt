package com.clean.poc_clean_architec.domain.usecases

import com.clean.poc_clean_architec.data.model.LoginRequestModel
import com.clean.poc_clean_architec.domain.repo.LoginRepo
import javax.inject.Inject

class LoginUserUseCases @Inject constructor(var loginRepo: LoginRepo) {

    fun login(loginRequestModel: LoginRequestModel) = loginRepo.login(loginRequestModel)

}