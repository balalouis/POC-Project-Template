package com.clean.poc_clean_architec.data.model

data class LoginRequestModel(
    val email: String,
    val password: String
)

data class LoginResponseModel(
    val token: String
)