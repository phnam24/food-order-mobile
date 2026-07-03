package com.example.foodorderrework.feature.auth.domain.model

enum class Role {
    CUSTOMER,
    STORE_OWNER,
    ADMIN,
}

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val avatarUrl: String,
    val role: Role = Role.CUSTOMER,
    val password: String,
)