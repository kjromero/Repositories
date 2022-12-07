package com.kenny.repo.domain.services

import com.kenny.repo.domain.services.model.RepositoriesResponse
import retrofit2.http.GET
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Query


interface RepoService {

    @GET("repositories")
    fun getRepositories(
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): Single<RepositoriesResponse>

}