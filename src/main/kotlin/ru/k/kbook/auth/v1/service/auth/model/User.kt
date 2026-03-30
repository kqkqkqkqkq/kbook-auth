package ru.k.kbook.auth.v1.service.auth.model

import kotlinx.datetime.LocalDate

data class User(
    val id: Long,
    val firstName: String?,
    val lastName: String?,
    val email: String,
    val phone: String?,
    val isEmailVerified: Boolean,
    val isPhoneVerified: Boolean,
    val username: String,
    val passwordHash: String,
    val createdAt: LocalDate,
    val lastUpdatedAt: LocalDate,
    val dateOfBirth: LocalDate?,
)