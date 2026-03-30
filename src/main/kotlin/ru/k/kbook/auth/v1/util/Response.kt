package ru.k.kbook.auth.v1.util

data class Response<T>(
    val isSuccess: Boolean,
    val code: Int,
    val data: T?,
    val message: String? = null,
)
