package com.clean.poc_clean_architec.domain.usecases

import com.clean.poc_clean_architec.domain.repo.GetUserDetailRepo
import javax.inject.Inject

class GetUserDetailUseCases @Inject constructor(private val getUserDetailRepo: GetUserDetailRepo) {
    suspend fun getUserDetail(userId: String) = getUserDetailRepo.fetchUserDetail(userId)
}