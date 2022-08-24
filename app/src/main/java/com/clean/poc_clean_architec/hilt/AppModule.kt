package com.clean.poc_clean_architec.hilt

import com.clean.poc_clean_architec.login.data.repo.LoginRepoImpl
import com.clean.poc_clean_architec.user_detail.data.mapper.UserDetailMapper
import com.clean.poc_clean_architec.login.domain.repo.LoginRepo
import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.registration.data.repo.RegisterRepoImpl
import com.clean.poc_clean_architec.registration.domain.repo.RegisterRepo
import com.clean.poc_clean_architec.user_detail.data.repo.GetUserDetailRepoImpl
import com.clean.poc_clean_architec.user_detail.domain.repo.GetUserDetailRepo
import com.clean.poc_clean_architec.user_list.data.mapper.UserListMapper
import com.clean.poc_clean_architec.user_list.data.repo.GetUserListRepoImpl
import com.clean.poc_clean_architec.user_list.domain.repo.GetUserListRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideGetUserListUseCases(apiService: ApiWebService, userListMapper: UserListMapper): GetUserListRepo {
        return GetUserListRepoImpl(apiService, userListMapper)
    }

    @Provides
    fun provideGetUserDetailUseCases(apiService: ApiWebService, userDetailMapper: UserDetailMapper): GetUserDetailRepo {
        return GetUserDetailRepoImpl(apiService, userDetailMapper)
    }

    @Provides
    fun provideLoginUseCases(apiService: ApiWebService): LoginRepo {
        return LoginRepoImpl(apiService)
    }

    @Provides
    fun provideRegisterUseCases(apiService: ApiWebService) : RegisterRepo {
        return RegisterRepoImpl(apiService)
    }
}