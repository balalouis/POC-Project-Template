package com.clean.poc_clean_architec.hilt

import com.clean.poc_clean_architec.data.mapper.CleanMapper
import com.clean.poc_clean_architec.data.repo.GetUserDetailRepoImpl
import com.clean.poc_clean_architec.data.repo.GetUserListRepoImpl
import com.clean.poc_clean_architec.domain.repo.GetUserDetailRepo
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import com.clean.poc_clean_architec.network.ApiWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideGetUserListUseCases(apiService: ApiWebService, cleanMapper: CleanMapper): GetUserListRepo {
        return GetUserListRepoImpl(apiService, cleanMapper)
    }

    @Provides
    fun provideGetUserDetailUseCases(apiService: ApiWebService, cleanMapper: CleanMapper): GetUserDetailRepo {
        return GetUserDetailRepoImpl(apiService, cleanMapper)
    }
}