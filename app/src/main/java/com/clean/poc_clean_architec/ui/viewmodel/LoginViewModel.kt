package com.clean.poc_clean_architec.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.data.model.LoginRequestModel
import com.clean.poc_clean_architec.data.model.LoginResponseModel
import com.clean.poc_clean_architec.data.model.LoginUIState
import com.clean.poc_clean_architec.domain.usecases.LoginUserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var loginUserUseCases: LoginUserUseCases) :ViewModel() {

    private val _uiState = MutableStateFlow<LoginUIState>(LoginUIState.Success(LoginResponseModel()))
    val uiState: StateFlow<LoginUIState> = _uiState

    fun login(loginRequestModel: LoginRequestModel){
        viewModelScope.launch {
            loginUserUseCases.login(loginRequestModel)
                .catch { exception ->
                    _uiState.value = LoginUIState.Failure(exception)
                }
                .collect {
                    _uiState.value = LoginUIState.Success(it)
                }
        }
    }
}