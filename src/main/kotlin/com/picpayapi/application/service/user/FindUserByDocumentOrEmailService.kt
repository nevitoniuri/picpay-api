package com.picpayapi.application.service.user

import com.picpayapi.adapters.entity.User
import java.util.*

fun interface FindUserByDocumentOrEmailService {
    fun execute(document: String, email: String): Optional<User>
}