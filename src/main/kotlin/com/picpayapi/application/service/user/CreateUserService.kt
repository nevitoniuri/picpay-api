package com.picpayapi.application.service.user

import com.picpayapi.application.model.User

fun interface CreateUserService {
    fun execute(user: User)
}