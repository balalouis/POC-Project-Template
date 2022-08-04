package com.clean.poc_clean_architec.data.model

data class LoginRequestModel(
    val email: String,
    val password: String
)

data class LoginResponseModel(
    val token: String
)

sealed class LoginUIState {
    data class Success(var loginResponseModel: LoginResponseModel?) : LoginUIState()
    data class Failure(var exception: Throwable) : LoginUIState()
}