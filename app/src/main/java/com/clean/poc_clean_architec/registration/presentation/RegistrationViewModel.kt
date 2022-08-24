package com.clean.poc_clean_architec.registration.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.registration.data.model.RegistrationRequestModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationResponseModel
import com.clean.poc_clean_architec.registration.data.model.RegistrationUiState
import com.clean.poc_clean_architec.registration.domain.usecases.RegistrationUserUserCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private var registrationUserUserCases: RegistrationUserUserCases) : ViewModel() {

    private var _uiState: MutableStateFlow<RegistrationUiState> = MutableStateFlow(
        RegistrationUiState.Success(
        RegistrationResponseModel()
    ))
    var uiState:StateFlow<RegistrationUiState> = _uiState

    fun register(registrationRequestModel: RegistrationRequestModel){
        viewModelScope.launch {
            registrationUserUserCases.register(registrationRequestModel)
                .catch { exception ->
                    _uiState.value= RegistrationUiState.Error(exception)
                }
                .collect {
                    _uiState.value= RegistrationUiState.Success(it)
                }
        }
    }

}