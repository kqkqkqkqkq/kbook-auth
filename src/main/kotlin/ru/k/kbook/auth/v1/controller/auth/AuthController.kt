package ru.k.kbook.auth.v1.controller.auth

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.body
import ru.k.kbook.auth.v1.controller.auth.schema.request.LoginRequest
import ru.k.kbook.auth.v1.controller.auth.schema.request.RegisterRequest
import ru.k.kbook.auth.v1.controller.auth.schema.response.LoginResponse
import ru.k.kbook.auth.v1.controller.auth.schema.response.RegisterResponse
import ru.k.kbook.auth.v1.service.auth.AuthService
import ru.k.kbook.auth.v1.util.Response
import ru.k.kbook.auth.v1.util.mapper.auth.toLoginForm
import ru.k.kbook.auth.v1.util.mapper.auth.toLoginResponse
import ru.k.kbook.auth.v1.util.mapper.auth.toRegisterForm
import ru.k.kbook.auth.v1.util.mapper.auth.toRegisterResponse

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    suspend fun register(@Valid @RequestBody user: RegisterRequest): ResponseEntity<Response<RegisterResponse>> =
        authService.register(user.toRegisterForm()).fold(
            onSuccess = { registeredUser ->
                ResponseEntity.ok(Response(data = registeredUser.toRegisterResponse()))
            },
            onFailure = { e ->
                ResponseEntity.badRequest().body(Response(message = e.message))
            },
        )

    @PostMapping("/login")
    suspend fun login(@Valid @RequestBody user: LoginRequest): ResponseEntity<Response<LoginResponse>> =
        authService.login(user.toLoginForm()).fold(
            onSuccess = { user ->
                if (user == null) {
                    ResponseEntity.notFound().build()
                } else {
                    ResponseEntity.ok(Response(user.toLoginResponse()))
                }
            },
            onFailure = { e ->
                ResponseEntity.badRequest().body(Response(message = e.message))
            },
        )
}
