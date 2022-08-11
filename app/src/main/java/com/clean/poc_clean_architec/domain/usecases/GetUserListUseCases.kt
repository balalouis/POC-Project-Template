package com.clean.poc_clean_architec.domain.usecases

import com.clean.poc_clean_architec.domain.model.UserUIData
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserListUseCases @Inject constructor(private val getUserListRepo: GetUserListRepo) {

    suspend fun getUserList(): Flow<List<UserUIData>> = getUserListRepo.fetchUserList()

}