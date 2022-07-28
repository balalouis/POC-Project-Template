package com.clean.poc_clean_architec.domain.usecases

import com.clean.poc_clean_architec.domain.model.UserList
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import javax.inject.Inject

class GetUserListUseCases @Inject constructor(private val getUserListRepo: GetUserListRepo) {

    suspend fun getUserList(): UserList = getUserListRepo.fetchUserList()

}