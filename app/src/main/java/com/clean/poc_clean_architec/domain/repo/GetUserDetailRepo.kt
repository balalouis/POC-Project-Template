package com.clean.poc_clean_architec.domain.repo

import com.clean.poc_clean_architec.domain.model.UserUIData
import kotlinx.coroutines.flow.Flow

interface GetUserDetailRepo {
    suspend fun fetchUserDetail(userId: String): Flow<UserUIData>
}