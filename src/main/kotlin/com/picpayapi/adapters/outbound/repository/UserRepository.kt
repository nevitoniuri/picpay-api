package com.picpayapi.adapters.outbound.repository

import com.picpayapi.adapters.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findUserByDocumentOrEmail(document: String, email: String): Optional<User>
}