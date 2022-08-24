package com.clean.poc_clean_architec.user_detail.domain.model


data class UserUIData(
    var id: Int = 0,
    var userEmail: String? = null,
    var userFirstName: String = "",
    var userLastName: String = "",
    var userAvatar: String = ""
)

sealed class UserUIState {
    data class Success(var userList: List<UserUIData>?) : UserUIState()
    data class Failure(var exception: Throwable) : UserUIState()
}

sealed class UserDetailUIState {
    data class Success(var user: UserUIData?) : UserDetailUIState()
    data class Failure(var exception: Throwable) : UserDetailUIState()
}