package com.kenny.repo.domain.services

import com.kenny.repo.domain.services.model.RepositoriesResponse
import retrofit2.http.GET
import io.reactivex.rxjava3.core.Single


interface RepoService {

    @GET("repositories?q=kotlin&per_page=20&page=1")
    fun getRepositories(): Single<RepositoriesResponse>

}