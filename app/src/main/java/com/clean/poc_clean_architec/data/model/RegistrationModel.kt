package com.clean.poc_clean_architec.data.model

data class RegistrationRequestModel(val email: String, val password: String)

data class RegistrationResponseModel(val id: Int, val token: String?)

sealed class RegistrationUiState {
    data class Success(var registrationResponseModel: RegistrationResponseModel?) : RegistrationUiState()
    data class Error(var exception: Throwable) : RegistrationUiState()
}