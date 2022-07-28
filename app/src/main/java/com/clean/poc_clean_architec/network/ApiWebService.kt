package com.clean.poc_clean_architec.network

import com.clean.poc_clean_architec.domain.model.UserList
import com.clean.poc_clean_architec.model.UserListRoot
import retrofit2.http.GET

interface ApiWebService {

    @GET("api/users?page=2")
    suspend fun fetchUserList(): UserListRoot

    @GET("api/users?page=2")
    suspend fun fetchUserListDummy(): UserList

}
