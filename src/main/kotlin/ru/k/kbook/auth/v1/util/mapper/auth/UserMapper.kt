package ru.k.kbook.auth.v1.util.mapper.auth

import kotlinx.datetime.toKotlinLocalDate
import ru.k.kbook.auth.v1.controller.auth.schema.request.RegisterRequest
import ru.k.kbook.auth.v1.controller.auth.schema.response.RegisterResponse
import ru.k.kbook.auth.v1.repository.auth.entity.UserDbo
import ru.k.kbook.auth.v1.service.auth.model.User
import ru.k.kbook.auth.v1.service.auth.model.UserForm

fun RegisterRequest.toUserForm() = UserForm(
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone,
    username = username,
    password = password,
    dateOfBirth = dateOfBirth,
)

fun UserDbo.toUser() = User(
    id = id!!,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone,
    isEmailVerified = isEmailVerified,
    isPhoneVerified = isPhoneVerified,
    username = username,
    passwordHash = passwordHash,
    createdAt = createdAt.toKotlinLocalDate(),
    lastUpdatedAt = lastUpdatedAt.toKotlinLocalDate(),
    dateOfBirth = dateOfBirth?.toKotlinLocalDate(),
)

fun User.toRegisterResponse() = RegisterResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phone = phone,
    isEmailVerified = isEmailVerified,
    isPhoneVerified = isPhoneVerified,
    username = username,
    passwordHash = passwordHash,
    createdAt = createdAt,
    lastUpdatedAt = lastUpdatedAt,
    dateOfBirth = dateOfBirth,
)
