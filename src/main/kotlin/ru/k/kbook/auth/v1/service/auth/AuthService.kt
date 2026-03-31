package ru.k.kbook.auth.v1.service.auth

import ru.k.kbook.auth.v1.service.auth.model.LoginForm
import ru.k.kbook.auth.v1.service.auth.model.RegisterForm
import ru.k.kbook.auth.v1.service.auth.model.User

interface AuthService {
    suspend fun register(user: RegisterForm): Result<User>
    suspend fun login(user: LoginForm): Result<User?>
}
