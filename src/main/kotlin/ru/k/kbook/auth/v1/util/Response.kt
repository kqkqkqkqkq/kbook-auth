package ru.k.kbook.auth.v1.util

data class Response<T>(val data: T? = null, val message: String? = null)
