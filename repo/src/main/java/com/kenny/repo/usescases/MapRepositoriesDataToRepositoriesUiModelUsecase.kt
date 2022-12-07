package com.kenny.repo.usescases

import com.kenny.core.usecase.UseCase
import com.kenny.repo.entities.entities.data.Repository
import com.kenny.repo.uimodels.RepositoriesUiModel
import com.kenny.repo.uimodels.RepositoryModel
import javax.inject.Inject

class MapRepositoriesDataToRepositoriesUiModelUsecase @Inject constructor() :
    UseCase<List<Repository>, RepositoriesUiModel>() {

    override fun execute(input: List<Repository>): RepositoriesUiModel {
        return RepositoriesUiModel(
            repositories = input.map {
                it.toBaseModel()
            }
        )
    }

    private fun Repository.toBaseModel(): RepositoryModel {
        return RepositoryModel(
            id = id,
            language =  language,
            name = name,
            fullName = fullName,
            description = description,
            visibility = visibility,
        )
    }

}