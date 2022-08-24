package com.clean.poc_clean_architec.user_detail.domain.repo

import com.clean.poc_clean_architec.user_detail.domain.model.UserUIData
import kotlinx.coroutines.flow.Flow

interface GetUserDetailRepo {
    fun fetchUserDetail(userId: String): Flow<UserUIData>
}