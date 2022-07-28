package com.clean.poc_clean_architec.hilt

import com.clean.poc_clean_architec.data.mapper.MyMapper
import com.clean.poc_clean_architec.data.repo.GetUserListRepoImpl
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
    fun provideGetUserListUseCases(apiService: ApiWebService, myMapper: MyMapper): GetUserListRepo {
        return GetUserListRepoImpl(apiService, myMapper)
    }


}