package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.data.model.UserListServerData
import com.clean.poc_clean_architec.data.model.UserDetailServerData
import retrofit2.http.GET

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserList(): UserListServerData

    @GET("api/users/{id}")
    suspend fun fetchUserDetail(): UserDetailServerData
}
