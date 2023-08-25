package com.picpayapi.application.service.user

import com.picpayapi.adapters.entity.Transaction

fun interface UpdateUsersBalance {
    fun execute(transaction: Transaction)
}