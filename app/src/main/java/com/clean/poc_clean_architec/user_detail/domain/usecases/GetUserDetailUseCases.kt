package com.clean.poc_clean_architec.user_detail.domain.usecases

import com.clean.poc_clean_architec.user_detail.domain.repo.GetUserDetailRepo
import javax.inject.Inject

class GetUserDetailUseCases @Inject constructor(private val getUserDetailRepo: GetUserDetailRepo) {
    fun getUserDetail(userId: String) = getUserDetailRepo.fetchUserDetail(userId)
}