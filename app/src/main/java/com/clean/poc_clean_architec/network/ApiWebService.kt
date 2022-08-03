package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.data.model.SingleUser
import com.clean.poc_clean_architec.data.model.UserListServerData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserList(): UserListServerData

    @GET("api/users/{id}")
    suspend fun fetchUserDetail(@Path("id") id: String): SingleUser
}
