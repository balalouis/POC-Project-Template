package com.clean.poc_clean_architec.uilayer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.domain.model.UserUIState
import com.clean.poc_clean_architec.domain.usecases.GetUserListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CleanViewModel @Inject constructor(var getUserListUseCases: GetUserListUseCases) : ViewModel() {

    private var uiState: MutableStateFlow<UserUIState> = MutableStateFlow(UserUIState.Success(emptyList()))
    var _uiState = uiState

    fun fetchUserList() {
        viewModelScope.launch {
            val userList = getUserListUseCases.getUserList()
            _uiState.value = UserUIState.Success(userList = userList.userModelList)
        }
    }

}