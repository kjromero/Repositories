package com.kenny.repo.entities.entities.data

import java.io.Serializable

data class Repository(
    val id: Int,
    val language: String,
    val name: String,
    val fullName: String,
    val description: String,
): Serializable
