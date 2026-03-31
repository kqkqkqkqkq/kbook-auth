package ru.k.kbook.auth.v1.controller.auth

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.k.kbook.auth.v1.controller.auth.schema.request.RegisterRequest
import ru.k.kbook.auth.v1.service.auth.AuthService
import ru.k.kbook.auth.v1.util.Response
import ru.k.kbook.auth.v1.util.mapper.auth.toRegisterResponse
import ru.k.kbook.auth.v1.util.mapper.auth.toUserForm

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    suspend fun register(@Valid @RequestBody user: RegisterRequest) = authService.register(user.toUserForm()).fold(
        onSuccess = { registeredUser ->
            Response(
                true,
                201,
                registeredUser.toRegisterResponse(),
                "Successfully registered user ${registeredUser.username}!",
            )
        },
        onFailure = { e ->
            Response(
                false,
                400,
                null,
                e.message ?: "Registration failed",
            )
        },
    )

    @PostMapping("/login")
    suspend fun login() {
    }
}
