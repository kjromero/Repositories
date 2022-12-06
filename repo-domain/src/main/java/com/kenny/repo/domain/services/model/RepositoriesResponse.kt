package com.kenny.repo.domain.services.model

import com.google.gson.annotations.SerializedName

data class RepositoriesResponse(
    @SerializedName("items") val items: List<RepositoryResponse>,
)
