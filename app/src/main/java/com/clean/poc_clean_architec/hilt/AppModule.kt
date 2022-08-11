package com.clean.poc_clean_architec.hilt

import com.clean.poc_clean_architec.data.mapper.CleanMapper
import com.clean.poc_clean_architec.data.repo.GetUserDetailRepoImpl
import com.clean.poc_clean_architec.data.repo.GetUserListRepoImpl
import com.clean.poc_clean_architec.data.repo.LoginRepoImpl
import com.clean.poc_clean_architec.data.repo.RegisterRepoImpl
import com.clean.poc_clean_architec.domain.repo.GetUserDetailRepo
import com.clean.poc_clean_architec.domain.repo.GetUserListRepo
import com.clean.poc_clean_architec.domain.repo.LoginRepo
import com.clean.poc_clean_architec.domain.repo.RegisterRepo
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideGetUserListUseCases(
        userDao: UserDao,
        apiService: ApiWebService,
        cleanMapper: CleanMapper
    ): GetUserListRepo {
        return GetUserListRepoImpl(userDao, apiService, cleanMapper)
    }

    @Provides
    fun provideGetUserDetailUseCases(
        userDao: UserDao,
        apiService: ApiWebService,
        cleanMapper: CleanMapper
    ): GetUserDetailRepo {
        return GetUserDetailRepoImpl(userDao, apiService, cleanMapper)
    }

    @Provides
    fun provideLoginUseCases(apiService: ApiWebService): LoginRepo {
        return LoginRepoImpl(apiService)
    }

    @Provides
    fun provideRegisterUseCases(apiService: ApiWebService): RegisterRepo {
        return RegisterRepoImpl(apiService)
    }
}