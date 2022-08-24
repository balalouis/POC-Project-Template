package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.login.data.model.LoginRequestModel
import com.clean.poc_clean_architec.login.data.model.LoginResponseModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationResponseModel
import com.clean.poc_clean_architec.user_detail.data.model.UserDetailServerRootData
import com.clean.poc_clean_architec.user_list.data.model.UserListServerData
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
