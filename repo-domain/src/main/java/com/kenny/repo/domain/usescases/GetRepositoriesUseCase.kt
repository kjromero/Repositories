package com.kenny.repo.domain.usescases

import com.kenny.core.usecase.SingleUseCase
import com.kenny.repo.domain.repositories.RepoRepositoryImpl
import com.kenny.repo.entities.entities.data.Repository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repoRepository: RepoRepositoryImpl
) : SingleUseCase<Unit, List<@JvmSuppressWildcards Repository>>() {

    override fun execute(input: Unit): Single<List<Repository>> {
        return repoRepository.getRepositories()
    }
}