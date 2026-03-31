package ru.k.kbook.auth.v1.service.auth.model

import kotlinx.datetime.LocalDate

data class RegisterForm(
    val firstName: String?,
    val lastName: String?,
    val email: String,
    val phone: String?,
    val username: String,
    val password: String,
    val dateOfBirth: LocalDate?,
)
