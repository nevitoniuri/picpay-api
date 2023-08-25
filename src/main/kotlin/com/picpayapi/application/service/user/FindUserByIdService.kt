package com.picpayapi.application.service.user

import com.picpayapi.adapters.entity.User

fun interface FindUserByIdService {
    fun execute(id: Long): User
}