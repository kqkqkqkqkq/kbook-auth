package ru.k.kbook.auth.v1.repository.auth

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.k.kbook.auth.v1.repository.auth.entity.UserDbo

@Repository
interface AuthRepository : CrudRepository<UserDbo, Long> {
    @Query("select * from users where email = :email")
    fun findByEmail(email: String): UserDbo?
}
