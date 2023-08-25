package com.picpayapi.adapters.mapper

import com.picpayapi.adapters.dto.request.UserCreateRequest
import com.picpayapi.adapters.dto.response.UserResponse
import com.picpayapi.adapters.entity.User
import com.picpayapi.adapters.entity.UserType
import java.math.BigDecimal

fun UserCreateRequest.toUser() = User(
    id = null,
    firstName = firstName,
    lastName = lastName,
    document = document,
    email = email,
    password = password,
    balance = BigDecimal.ZERO,
    userType = UserType.CONSUMER
)

fun User.toResponse() = UserResponse(
    id = id!!,
    firstName = firstName,
    lastName = lastName,
    document = document,
    email = email,
    balance = balance,
    userType = userType
)