package com.picpayapi.application.service.user

import com.picpayapi.application.model.Transaction

fun interface UpdateUsersBalance {
    fun execute(transaction: Transaction)
}