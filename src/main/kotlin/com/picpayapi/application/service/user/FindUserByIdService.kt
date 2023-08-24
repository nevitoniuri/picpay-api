package com.picpayapi.application.service.user

import com.picpayapi.application.model.User

fun interface FindUserByIdService {
    fun execute(id: Long): User
}