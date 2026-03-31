package ru.k.kbook.auth.v1.service.auth

import kotlinx.datetime.toJavaLocalDate
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.k.kbook.auth.v1.repository.auth.AuthRepository
import ru.k.kbook.auth.v1.repository.auth.entity.UserDbo
import ru.k.kbook.auth.v1.service.auth.model.UserForm
import ru.k.kbook.auth.v1.util.Timer
import ru.k.kbook.auth.v1.util.mapper.auth.toUser

@Service
class AuthServiceImpl(private val passwordEncoder: PasswordEncoder, private val authRepository: AuthRepository) :
    AuthService {

    override suspend fun register(user: UserForm) = runCatching {
        // TODO("implement logic")

        val currentDate = Timer.now().date
        val passwordHash = passwordEncoder.encode(user.password)

        val userDbo = UserDbo(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            phone = user.phone,
            isEmailVerified = false,
            isPhoneVerified = false,
            username = user.username,
            passwordHash = requireNotNull(passwordHash),
            createdAt = currentDate.toJavaLocalDate(),
            lastUpdatedAt = currentDate.toJavaLocalDate(),
            dateOfBirth = user.dateOfBirth?.toJavaLocalDate(),
        )
        authRepository.save(userDbo).toUser()
    }
}
