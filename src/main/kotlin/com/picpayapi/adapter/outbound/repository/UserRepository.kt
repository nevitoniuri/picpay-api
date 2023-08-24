package com.picpayapi.adapter.outbound.repository

import com.picpayapi.application.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>