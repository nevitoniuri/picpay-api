package com.picpayapi.adapters.dto.response

import com.picpayapi.adapters.entity.UserType
import java.math.BigDecimal

data class UserResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val document: String,
    val email: String,
    val balance: BigDecimal,
    val userType: UserType
)
