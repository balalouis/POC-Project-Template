package com.clean.poc_clean_architec.uilayer

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
class DummyViewModel @Inject constructor(var mainRepository: MainRepository) : ViewModel() {

    fun fetchUserList() {
        viewModelScope.launch {
            mainRepository.fetch()
                .catch { exception ->
                    Log.i("---->", "${exception.message} ")
                }
                .collect {
                    Log.i("---->", "User list:${it.userModelList} ")
                }
        }
    }

}