package ru.k.kbook.auth.v1.service.auth

import ru.k.kbook.auth.v1.service.auth.model.User
import ru.k.kbook.auth.v1.service.auth.model.UserForm

interface AuthService {
    suspend fun register(user: UserForm): Result<User>
}
