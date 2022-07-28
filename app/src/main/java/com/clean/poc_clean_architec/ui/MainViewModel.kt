package com.clean.poc_clean_architec.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.poc_clean_architec.repo.MainRepository
import com.clean.poc_clean_architec.model.UserUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var mainRepository: MainRepository) : ViewModel() {
    private var uiState: MutableStateFlow<UserUIState> = MutableStateFlow(UserUIState.Success(emptyList()))
    var _uiState = uiState

    fun fetchUserList() {
        viewModelScope.launch {
            mainRepository.fetch()
                .catch { exception ->
                    _uiState.value = UserUIState.Failure(exception)
                }
                .collect {
                    Log.i("---->", "User list:${it.userModelList} ")
                    _uiState.value = UserUIState.Success(it.userModelList)
                }
        }
    }

}