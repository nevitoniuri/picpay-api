package com.picpayapi.adapters.outbound.repository

import com.picpayapi.adapters.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>