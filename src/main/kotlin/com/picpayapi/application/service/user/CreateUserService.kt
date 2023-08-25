package com.picpayapi.application.service.user

import com.picpayapi.adapters.entity.User

fun interface CreateUserService {
    fun execute(user: User): User
}