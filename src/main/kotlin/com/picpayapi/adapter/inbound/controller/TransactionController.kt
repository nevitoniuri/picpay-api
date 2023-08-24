package com.picpayapi.adapter.inbound.controller

import com.picpayapi.adapter.inbound.controller.request.TransactionRequest
import com.picpayapi.application.model.Transaction
import com.picpayapi.application.service.transaction.CreateTransactionService
import com.picpayapi.application.service.user.FindUserByIdService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/transaction")
class TransactionController(
    private val createTransactionService: CreateTransactionService,
    private val findUserByIdService: FindUserByIdService
) {

    @PostMapping
    fun createTransaction(@RequestBody transaction: TransactionRequest) {
        createTransactionService.execute(
            Transaction(
                value = transaction.value,
                payer = findUserByIdService.execute(transaction.payerId),
                payee = findUserByIdService.execute(transaction.payeeId)
            )
        )
    }
}