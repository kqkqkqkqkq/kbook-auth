package ru.k.kbook.auth.v1.controller.auth.schema.response

import kotlinx.datetime.LocalDate

data class RegisterResponse(
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
