package com.clean.poc_clean_architec.domain.repo

import com.clean.poc_clean_architec.domain.model.UserUIData
import kotlinx.coroutines.flow.Flow

interface GetUserListRepo {
    suspend fun fetchUserList(): Flow<List<UserUIData>>
}