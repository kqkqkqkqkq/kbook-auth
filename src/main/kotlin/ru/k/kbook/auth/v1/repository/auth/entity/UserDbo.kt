package ru.k.kbook.auth.v1.repository.auth.entity

import java.time.LocalDate

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class UserDbo(
    @Id val id: Long? = null,
    @Column("first_name") val firstName: String?,
    @Column("last_name") val lastName: String?,
    @Column("email") val email: String,
    @Column("phone") val phone: String?,
    @Column("is_email_verified") val isEmailVerified: Boolean,
    @Column("is_phone_verified") val isPhoneVerified: Boolean,
    @Column("username") val username: String,
    @Column("password_hash") val passwordHash: String,
    @Column("created_at") val createdAt: LocalDate,
    @Column("last_updated_at") val lastUpdatedAt: LocalDate,
    @Column("date_of_birth") val dateOfBirth: LocalDate?,
)
