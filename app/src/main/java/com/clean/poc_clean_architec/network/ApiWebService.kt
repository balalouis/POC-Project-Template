package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserList(): UserListServerData

    @GET("api/users/{id}")
    suspend fun fetchUserDetail(@Path("id") id: String): UserDetailServerRootData

    @POST("api/login")
    suspend fun loginApiCall(@Body loginModel: LoginRequestModel): LoginResponseModel

    @POST("api/register")
    suspend fun registrationApiCall(@Body registrationRequestModel: RegistrationRequestModel): RegistrationResponseModel
}
