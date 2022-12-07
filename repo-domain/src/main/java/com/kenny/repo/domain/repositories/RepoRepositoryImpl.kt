package com.kenny.repo.domain.repositories

import com.kenny.repo.domain.services.RepoService
import com.kenny.repo.domain.services.model.RepositoryResponse
import com.kenny.repo.entities.entities.data.Repository
import com.kenny.repo.entities.interfaces.RepoRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val repoService: RepoService
) : RepoRepository {
    override fun getRepositories(query: String): Single<List<Repository>> {
        return repoService.getRepositories(query, 30, 1).map { it.items.map { repository ->  repository.toBaseModel() } }
    }

    private fun RepositoryResponse.toBaseModel(): Repository {
        return Repository(
            id = id,
            name = name,
            fullName = fullName,
            description = description,
            language = language,
            visibility = visibility,
        )
    }
}