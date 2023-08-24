package com.picpayapi.application.service.transaction

import com.picpayapi.application.model.Transaction

fun interface CreateTransactionService {
    fun execute(transaction: Transaction)
}