package com.kenny.repositories.di.modules

import com.kenny.repo.domain.services.RepoService
import com.kenny.repositories.di.qualifers.RetrofitBasic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NetworkServiceModule {

    @Provides
    fun provideRecipeService(@RetrofitBasic retrofit: Retrofit): RepoService {
        return retrofit.create(RepoService::class.java)
    }
}