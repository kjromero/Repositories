package com.kenny.repo.entities.interfaces

import com.kenny.repo.entities.entities.data.Repository
import io.reactivex.rxjava3.core.Single

interface RepoRepository {
    fun getRepositories(query: String): Single<List<Repository>>
}