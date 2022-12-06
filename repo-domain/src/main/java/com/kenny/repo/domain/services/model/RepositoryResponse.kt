package com.kenny.repo.domain.services.model

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("items") val language: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String,
)