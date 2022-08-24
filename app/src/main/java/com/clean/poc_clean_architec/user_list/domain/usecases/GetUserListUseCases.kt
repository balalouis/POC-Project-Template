package com.clean.poc_clean_architec.user_list.domain.usecases

import com.clean.poc_clean_architec.user_list.domain.model.UserList
import com.clean.poc_clean_architec.user_list.domain.repo.GetUserListRepo
import javax.inject.Inject

class GetUserListUseCases @Inject constructor(private val getUserListRepo: GetUserListRepo) {

    suspend fun getUserList(): UserList = getUserListRepo.fetchUserList()

}