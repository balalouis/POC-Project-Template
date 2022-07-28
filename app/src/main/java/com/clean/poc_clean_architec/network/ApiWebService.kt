package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.data.model.UserListServerData
import retrofit2.http.GET

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserListDummy(): UserListServerData

}
