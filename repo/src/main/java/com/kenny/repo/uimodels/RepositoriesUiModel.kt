package com.kenny.repo.uimodels

data class RepositoriesUiModel(
    val loading: Boolean = false,
    val repositories: List<RepositoryModel> = listOf(),
    val screen: RepositoriesScreen = RepositoriesScreen.Loader,
)

data class RepositoryModel(
    val id: Int,
    val language: String,
    val name: String,
    val fullName: String,
    val description: String,
)

sealed class RepositoriesScreen {
    object List : RepositoriesScreen()
    object Detail : RepositoriesScreen()
    object Loader : RepositoriesScreen()
}