package ru.k.kbook.auth.v1.controller.auth.schema.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlinx.datetime.LocalDate

data class RegisterRequest(
    val firstName: String?,
    val lastName: String?,
    @field:NotBlank(message = "Email must not be blank")
    @field:Email(message = "Invalid email format")
    val email: String,
    val phone: String?,
    @field:NotBlank(message = "Username is required")
    @field:Size(min = 1, max = 100, message = "Username must be between 3 and 50 characters")
    val username: String,
    @field:NotBlank(message = "Password is required")
    @field:Size(min = 6, message = "Password must be at least 6 characters")
    val password: String,
    val dateOfBirth: LocalDate?,
)
