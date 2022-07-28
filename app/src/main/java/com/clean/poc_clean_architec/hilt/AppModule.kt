package com.clean.poc_clean_architec.hilt

import com.clean.poc_clean_architec.network.ApiWebService
import com.clean.poc_clean_architec.repo.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providesRepository(apiService: ApiWebService) = MainRepository(apiService)
}