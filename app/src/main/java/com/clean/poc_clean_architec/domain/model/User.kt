package com.clean.poc_clean_architec.domain.model

data class UserList(
    var perPage: Int = 0,
    var totalPages: Int = 0,
    var userModelList: List<User>? = null
)

data class User(
    var userEmail: String? = null,
    var userFirstName: String = "",
    var userLastName: String = "",
    var userAvatar: String = ""
)

sealed class UserUIState {
    data class Success(var userList: List<User>?) : UserUIState()
    data class Failure(var exception: Throwable) : UserUIState()
}