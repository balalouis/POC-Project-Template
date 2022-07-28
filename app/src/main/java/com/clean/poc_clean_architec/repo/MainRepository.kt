package com.clean.poc_clean_architec.repo

import com.clean.poc_clean_architec.network.ApiWebService
import kotlinx.coroutines.flow.flow

class MainRepository(var apiWebService: ApiWebService) {

    suspend fun fetch() =
        flow {
            emit(apiWebService.fetchUserList())
        }

}