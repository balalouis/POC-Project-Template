package com.clean.poc_clean_architec.user_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.user_detail.domain.model.UserUIState
import com.clean.poc_clean_architec.user_list.domain.usecases.GetUserListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(var getUserListUseCases: GetUserListUseCases) : ViewModel() {

    private var uiState: MutableStateFlow<UserUIState> = MutableStateFlow(UserUIState.Success(emptyList()))
    var _uiState = uiState

    fun fetchUserList() {
        viewModelScope.launch {
            val userList = getUserListUseCases.getUserList()
            _uiState.value = UserUIState.Success(userList = userList.userModelList)
        }
    }

}