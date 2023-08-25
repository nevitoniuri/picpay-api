package com.picpayapi.application.service.transaction

import com.picpayapi.adapters.entity.Transaction

fun interface CreateTransactionService {
    fun execute(transaction: Transaction)
}