package com.clean.poc_clean_architec.user_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.user_detail.domain.model.UserDetailUIState
import com.clean.poc_clean_architec.user_detail.domain.usecases.GetUserDetailUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(var getUserDetailUseCases: GetUserDetailUseCases) :
    ViewModel() {

    private val _uiState = MutableStateFlow<UserDetailUIState>(UserDetailUIState.Success(null))
    val uiState: StateFlow<UserDetailUIState> = _uiState

    fun fetchUserDetail(userId: String) {
        viewModelScope.launch {
            getUserDetailUseCases.getUserDetail(userId)
                .catch { exception ->
                    _uiState.value = UserDetailUIState.Failure(exception)
                }
                .collect {
                    val singleUser = it
                    _uiState.value = UserDetailUIState.Success(singleUser)
                }
        }
    }

}