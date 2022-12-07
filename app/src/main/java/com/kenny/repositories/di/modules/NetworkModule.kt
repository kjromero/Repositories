package com.kenny.repositories.di.modules

import com.kenny.repositories.di.qualifers.BasePath
import com.kenny.repositories.di.qualifers.RetrofitBasic
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://api.github.com/search/"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    @BasePath
    fun providesBasePath(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    @RetrofitBasic
    fun providesRetrofitBasic(
        @BasePath basePath: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(basePath)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}