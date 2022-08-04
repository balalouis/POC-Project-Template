package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.data.model.LoginRequestModel
import com.clean.poc_clean_architec.data.model.LoginResponseModel
import com.clean.poc_clean_architec.data.model.UserDetailServerRootData
import com.clean.poc_clean_architec.data.model.UserListServerData
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
}
